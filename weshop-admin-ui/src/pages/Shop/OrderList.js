import React, {PureComponent} from 'react';
import {connect} from 'dva';
import {Button, Card, Col, Form, Input, Row} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './OrderList.less';

const FormItem = Form.Item;

@connect(({order, loading}) => ({
  order,
  loading: loading.models.order,
}))
@Form.create()
class OrderList extends PureComponent {
  state = {
    selectedRows: [],
    formValues: {},
  };

  columns = [
    {
      title: '订单ID',
      dataIndex: 'id',
    },
    {
      title: '创建时间',
      dataIndex: 'createTime',
    },
    {
      title: '用户ID',
      dataIndex: 'userId',
    },
    {
      title: '订单状态',
      dataIndex: 'orderStatus',
    },
    {
      title: '支付状态',
      dataIndex: 'payStatus',
    },
    {
      title: '支付金额',
      dataIndex: 'name',
    },
    {
      title: '支付时间',
      dataIndex: 'payTime',
    },
    {
      title: '操作',
      dataIndex: 'name',
    },
  ];

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'order/list',
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
      type: 'order/list',
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
        type: 'order/list',
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
      type: 'order/list',
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
            <FormItem label="区域ID">
              {getFieldDecorator('id')(<Input placeholder="请输入"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="区域名称">
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
  }

  render() {
    const {order, loading} = this.props;

    const {selectedRows} = this.state;
    return (
      <PageHeaderWrapper title="行政区域">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={order}
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

export default OrderList;
