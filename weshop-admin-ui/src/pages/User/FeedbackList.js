import React, {PureComponent} from 'react';
import {connect} from 'dva';
import {Button, Card, Col, Form, Input, Row} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './FeedbackList.less';
import moment from 'moment';

const FormItem = Form.Item;

@connect(({feedback, loading}) => ({
  feedback,
  loading: loading.models.feedback,
}))
@Form.create()
class FeedbackList extends PureComponent {
  state = {
    selectedRows: [],
    formValues: {},
  };

  columns = [
    {
      title: '反馈ID',
      dataIndex: 'msgId',
    },
    {
      title: '用户名',
      dataIndex: 'userName',
    },
    {
      title: '用户邮箱',
      dataIndex: 'userEmail',
    },
    {
      title: '反馈标题',
      dataIndex: 'msgTitle',
    },
    {
      title: '反馈状态',
      dataIndex: 'msgStatus',
    },
    {
      title: '反馈内容',
      dataIndex: 'msgContent',
    },
    {
      title: '反馈时间',
      dataIndex: 'msgTime',
      render: val => <span>{moment(val).format('YYYY-MM-DD HH:mm:ss')}</span>,
    },
  ];

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'feedback/list',
    });
  }

  handleStandardTableChange = (pagination, filtersArg, sorter) => {
    const {dispatch} = this.props;
    const {formValues} = this.state;

    const params = {
      pageNum: pagination.current,
      pageSize: pagination.pageSize,
      ...formValues,
    };
    if (sorter.field) {
      params.sorter = `${sorter.field}_${sorter.order}`;
    }

    dispatch({
      type: 'feedback/list',
      payload: params,
    });
  };

  handleSelectRows = rows => {
    this.setState({
      selectedRows: rows,
    });
  };

  handleSearch = e => {
    e.preventDefault();

    const {dispatch, form} = this.props;

    form.validateFields((err, fieldsValue) => {
      if (err) return;

      this.setState({
        formValues: fieldsValue,
      });

      dispatch({
        type: 'feedback/list',
        payload: fieldsValue,
      });
    });
  };

  handleFormReset = () => {
    const {form, dispatch} = this.props;
    form.resetFields();
    this.setState({
      formValues: {},
    });
    dispatch({
      type: 'feedback/list',
      payload: {},
    });
  };

  renderForm() {
    const {
      form: {getFieldDecorator},
    } = this.props;
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{md: 8, lg: 24, xl: 48}}>
          <Col md={8} sm={24}>
            <FormItem label="用户名">
              {getFieldDecorator('userName')(<Input placeholder="请输入"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="反馈ID">
              {getFieldDecorator('msgId')(<Input placeholder="请输入"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
              <Button type="primary" htmlType="submit">
                查询
              </Button>
              <Button style={{marginLeft: 8}} onClick={this.handleFormReset}>
                重置
              </Button>
            </span>
          </Col>
        </Row>
      </Form>
    );
  }

  render() {
    const {
      feedback,
      loading,
    } = this.props;

    const {selectedRows} = this.state;
    return (
      <PageHeaderWrapper title="意见反馈">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={feedback}
              columns={this.columns}
              onSelectRow={this.handleSelectRows}
              onChange={this.handleStandardTableChange}
            />
          </div>
        </Card>
      </PageHeaderWrapper>
    );
  }
}

export default FeedbackList;
