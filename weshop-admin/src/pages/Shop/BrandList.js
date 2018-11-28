import React, {PureComponent} from 'react';
import {connect} from 'dva';
import {
  Card,
  Form,
  Button, Row, Col, Input,
} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './BrandList.less';

const FormItem = Form.Item;

@connect(({brand, loading}) => ({
  brand,
  loading: loading.models.brand
}))
@Form.create()
class BrandList extends PureComponent {

  state = {
    selectedRows: [],
    formValues: {},
    updateFormValues: {},
  };

  columns = [
    {
      title: '品牌商ID',
      dataIndex: 'id',
    },
    {
      title: '品牌商名称',
      dataIndex: 'name'
    }, {
      title: '品牌商图片',
      dataIndex: 'picUrl',
      render: (text) => (
        <a href={text} target="_blank">
          <img src={text} width={65}/>
        </a>
      )
    }, {
      title: '介绍',
      dataIndex: 'simpleDesc'
    }, {
      title: '底价',
      dataIndex: 'floorPrice'
    },
  ]

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'brand/list',
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
      type: 'brand/list',
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
        type: 'brand/list',
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
      type: 'brand/list',
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
            <FormItem label="品牌商ID">
              {getFieldDecorator('id')(<Input placeholder="请输入"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="品牌商名称">
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
      brand,
      loading,
    } = this.props;

    const {selectedRows} = this.state;
    return (
      <PageHeaderWrapper title="行政区域">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={brand}
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

export default BrandList;
