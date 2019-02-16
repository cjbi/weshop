import React, {PureComponent} from 'react';
import {connect} from 'dva';
import {Button, Card, Col, Form, Input, Row} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './CollectList.less';
import moment from 'moment';

const FormItem = Form.Item;

@connect(({collect, loading}) => ({
  collect,
  loading: loading.models.collect,
}))
@Form.create()
class CollectList extends PureComponent {
  state = {
    selectedRows: [],
    formValues: {},
    updateFormValues: {},
  };

  columns = [
    {
      title: '收藏ID',
      dataIndex: 'id',
    },
    {
      title: '用户ID',
      dataIndex: 'userId',
    },
    {
      title: '商品ID',
      dataIndex: 'valueId',
    },
    {
      title: '添加时间',
      dataIndex: 'createTime',
      render: val => <span>{moment(val).format('YYYY-MM-DD HH:mm:ss')}</span>,
    },
  ];

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'collect/list',
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
      type: 'collect/list',
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
        type: 'collect/list',
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
      type: 'collect/list',
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
            <FormItem label="用户ID">
              {getFieldDecorator('userId')(<Input placeholder="请输入"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="商品ID">
              {getFieldDecorator('goodsId')(<Input placeholder="请输入"/>)}
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
      collect,
      loading,
    } = this.props;

    const {selectedRows} = this.state;
    return (
      <PageHeaderWrapper title="会员收藏">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={collect}
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

export default CollectList;
