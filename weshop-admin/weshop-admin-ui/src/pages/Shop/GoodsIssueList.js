import React, {Fragment, PureComponent} from 'react';
import {connect} from 'dva';
import {Button, Card, Col, Divider, Form, Input, message, Modal, Row} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './GoodsIssueList.less';

const FormItem = Form.Item;

@connect(({goodsIssue, loading}) => ({
  goodsIssue,
  loading: loading.models.goodsIssue,
}))
@Form.create()
class GoodsIssueList extends PureComponent {
  state = {
    modalVisible: false,
    updateModalVisible: false,
    expandForm: false,
    selectedRows: [],
    formValues: {},
    updateFormValues: {},
  };

  columns = [
    {
      title: '问题ID',
      dataIndex: 'id',
    },
    {
      title: '问题内容',
      dataIndex: 'question',
    },
    {
      title: '问题回复',
      dataIndex: 'answer',
    },
    {
      title: '操作',
      render: (text, record) => (
        <Fragment>
          <a onClick={() => this.handleUpdateModalVisible(true, record)}>修改</a>
          <Divider type="vertical"/>
          <a onClick={() => this.handleDeleteGoodsIssue([record.id])}>删除</a>
        </Fragment>
      ),
    },
  ];

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'goodsIssue/list',
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
      type: 'goodsIssue/list',
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
        type: 'goodsIssue/list',
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
      type: 'goodsIssue/list',
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
            <FormItem label="问题内容">
              {getFieldDecorator('question')(<Input placeholder="请输入问题内容"/>)}
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

  handleModalVisible = flag => {
    this.setState({
      modalVisible: !!flag,
    });
  };

  handleUpdateModalVisible = (flag, record) => {
    this.setState({
      updateModalVisible: !!flag,
      updateFormValues: record || {},
    });
  };

  handleDeleteGoodsIssue = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'goodsIssue/delete',
      payload: params,
      callback: response => {
        message.success(response.msg);
        dispatch({type: 'goodsIssue/list'});
        this.setState({
          selectedRows: [],
        });
      },
    });
  };

  handleUpdateGoodsIssue = fields => {
    const {dispatch} = this.props;
    dispatch({
      type: 'goodsIssue/update',
      payload: fields,
      callback: response => {
        message.success(response.msg);
        this.handleUpdateModalVisible();
        dispatch({type: 'goodsIssue/list'});
      },
    });
  };

  handleCreateGoodsIssue = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'goodsIssue/create',
      payload: params,
      callback: response => {
        message.success(response.msg);
        this.handleModalVisible();
        dispatch({type: 'goodsIssue/list'});
      },
    });
  };

  render() {
    const {goodsIssue, loading} = this.props;

    const {selectedRows, modalVisible, updateModalVisible, updateFormValues} = this.state;
    const parentMethods = {
      loading,
      handleCreateGoodsIssue: this.handleCreateGoodsIssue,
      handleModalVisible: this.handleModalVisible,
    };
    const updateMethods = {
      loading,
      handleUpdateModalVisible: this.handleUpdateModalVisible,
      handleUpdateGoodsIssue: this.handleUpdateGoodsIssue,
    };
    return (
      <PageHeaderWrapper title="商品问题">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <div className={styles.tableListOperator}>
              <Button icon="plus" type="primary" onClick={() => this.handleModalVisible(true)}>
                新建
              </Button>
              {selectedRows.length > 0 && (
                <span>
                  <Button
                    onClick={() => this.handleDeleteGoodsIssue(selectedRows.map(row => row.id))}
                  >
                    删除
                  </Button>
                </span>
              )}
            </div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={goodsIssue}
              columns={this.columns}
              onSelectRow={this.handleSelectRows}
              onChange={this.handleStandardTableChange}
            />
          </div>
        </Card>
        <CreateForm {...parentMethods} modalVisible={modalVisible}/>
        {updateFormValues && Object.keys(updateFormValues).length ? (
          <UpdateForm
            {...updateMethods}
            updateModalVisible={updateModalVisible}
            values={updateFormValues}
          />
        ) : null}
      </PageHeaderWrapper>
    );
  }
}

@Form.create()
class UpdateForm extends PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      formVals: {
        ...props.values,
      },
    };

    this.formLayout = {
      labelCol: {span: 5},
      wrapperCol: {span: 15},
    };
  }

  render() {
    const {
      loading,
      form,
      updateModalVisible,
      handleUpdateGoodsIssue,
      handleUpdateModalVisible,
    } = this.props;
    const {formVals} = this.state;
    const {labelCol, wrapperCol} = this.formLayout;
    const okHandle = () => {
      form.validateFields((err, fieldsValue) => {
        if (err) return;
        const params = {
          ...formVals,
          ...fieldsValue,
        };
        handleUpdateGoodsIssue(params);
      });
    };
    const extractPicUrl = res => {
      form.setFieldsValue({picUrl: res.data});
    };
    return (
      <Modal
        confirmLoading={loading}
        destroyOnClose
        title="修改商品问题"
        visible={updateModalVisible}
        onOk={okHandle}
        onCancel={() => handleUpdateModalVisible()}
      >
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="问题">
          {form.getFieldDecorator('question', {
            rules: [{required: true, message: '请输入至少五个字符！', min: 5}],
            initialValue: formVals.question,
          })(<Input placeholder="请输入问题"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="回复">
          {form.getFieldDecorator('answer', {
            rules: [{required: true, message: '请输入至少五个字符！', min: 5}],
            initialValue: formVals.answer,
          })(<Input placeholder="请输入回复"/>)}
        </FormItem>
      </Modal>
    );
  }
}

const CreateForm = Form.create()(props => {
  const {loading, modalVisible, form, handleCreateGoodsIssue, handleModalVisible} = props;

  const okHandle = () => {
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      form.resetFields();
      handleCreateGoodsIssue(fieldsValue);
    });
  };

  const {labelCol, wrapperCol} = {
    labelCol: {span: 5},
    wrapperCol: {span: 15},
  };
  return (
    <Modal
      confirmLoading={loading}
      destroyOnClose
      title="新建商品问题"
      visible={modalVisible}
      onOk={okHandle}
      onCancel={() => handleModalVisible()}
    >
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="问题">
        {form.getFieldDecorator('question', {
          rules: [{required: true, message: '请输入至少五个字符！', min: 5}],
        })(<Input placeholder="请输入问题"/>)}
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="回复">
        {form.getFieldDecorator('answer', {
          rules: [{required: true, message: '请输入至少五个字符！', min: 5}],
        })(<Input placeholder="请输入回复"/>)}
      </FormItem>
    </Modal>
  );
});

export default GoodsIssueList;
