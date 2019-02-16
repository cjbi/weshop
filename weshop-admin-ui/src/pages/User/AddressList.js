import React, {PureComponent} from 'react';
import {connect} from 'dva';
import {Button, Card, Col, Form, Input, Row,} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './AddressList.less';

const FormItem = Form.Item;

const isDefaultMap = {
  true: '是',
  false: '否'
};

@connect(({address, loading}) => ({
  address,
  loading: loading.models.address
}))
@Form.create()
class AddressList extends PureComponent {

  state = {
    selectedRows: [],
    formValues: {},
  };

  columns = [
    {
      title: '地址ID',
      dataIndex: 'id',
    },
    {
      title: '用户ID',
      dataIndex: 'userId'
    },
    {
      title: '收货人名称',
      dataIndex: 'name'
    },
    {
      title: '手机号码',
      dataIndex: 'mobile'
    }, {
      title: '地址',
      dataIndex: 'address'
    }, {
      title: '默认',
      dataIndex: 'isDefault',
      render: text => {
        return isDefaultMap[text];
      }
    },
  ]

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'address/list',
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
      type: 'address/list',
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
        type: 'address/list',
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
      type: 'address/list',
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
            <FormItem label="收货人名称">
              {getFieldDecorator('name')(<Input placeholder="请输入"/>)}
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
  };


  render() {
    const {
      address,
      loading,
    } = this.props;

    const {selectedRows} = this.state;
    return (
      <PageHeaderWrapper title="收获地址">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={address}
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

export default AddressList;
