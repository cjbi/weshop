import React, {Fragment, PureComponent} from 'react';
import {connect} from 'dva';
import {Button, Card, Col, Divider, Form, Input, message, Modal, Row, Select} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './KeywordsList.less';

const FormItem = Form.Item;

const isMap = {
  true: '是',
  false: '否',
};

@connect(({keywords, loading}) => ({
  keywords,
  loading: loading.models.keywords,
}))
@Form.create()
class KeywordsList extends PureComponent {
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
      title: '关键词ID',
      dataIndex: 'id',
    },
    {
      title: '关键词',
      dataIndex: 'keyword',
    },
    {
      title: '跳转链接',
      dataIndex: 'schemeUrl',
    },
    {
      title: '是否热词',
      dataIndex: 'isHot',
      render: (text, record) => {
        return isMap[text];
      },
    },
    {
      title: '是否显示',
      dataIndex: 'isShow',
      render: (text, record) => {
        return isMap[text];
      },
    },
    {
      title: '是否默认',
      dataIndex: 'isDefault',
      render: (text, record) => {
        return isMap[text];
      },
    },
    {
      title: '操作',
      render: (text, record) => (
        <Fragment>
          <a onClick={() => this.handleUpdateModalVisible(true, record)}>修改</a>
          <Divider type="vertical"/>
          <a onClick={() => this.handleDeleteKeywords([record.id])}>删除</a>
        </Fragment>
      ),
    },
  ];

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'keywords/list',
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
      type: 'keywords/list',
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
        type: 'keywords/list',
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
      type: 'keywords/list',
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
            <FormItem label="关键词">
              {getFieldDecorator('keyword')(<Input placeholder="请输入关键词"/>)}
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

  handleDeleteKeywords = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'keywords/delete',
      payload: params,
      callback: response => {
        message.success(response.msg);
        dispatch({type: 'keywords/list'});
        this.setState({
          selectedRows: [],
        });
      },
    });
  };

  handleUpdateKeywords = fields => {
    const {dispatch} = this.props;
    dispatch({
      type: 'keywords/update',
      payload: fields,
      callback: response => {
        message.success(response.msg);
        this.handleUpdateModalVisible();
        dispatch({type: 'keywords/list'});
      },
    });
  };

  handleCreateKeywords = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'keywords/create',
      payload: params,
      callback: response => {
        message.success(response.msg);
        this.handleModalVisible();
        dispatch({type: 'keywords/list'});
      },
    });
  };

  render() {
    const {keywords, loading} = this.props;

    const {selectedRows, modalVisible, updateModalVisible, updateFormValues} = this.state;
    const parentMethods = {
      loading,
      handleCreateKeywords: this.handleCreateKeywords,
      handleModalVisible: this.handleModalVisible,
    };
    const updateMethods = {
      loading,
      handleUpdateModalVisible: this.handleUpdateModalVisible,
      handleUpdateKeywords: this.handleUpdateKeywords,
    };
    return (
      <PageHeaderWrapper title="关键词">
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
                    onClick={() => this.handleDeleteKeywords(selectedRows.map(row => row.id))}
                  >
                    删除
                  </Button>
                </span>
              )}
            </div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={keywords}
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
      handleUpdateKeywords,
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
        handleUpdateKeywords(params);
      });
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
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="关键词">
          {form.getFieldDecorator('keyword', {
            rules: [{required: true, message: '不能为空！'}],
            initialValue: formVals.keyword,
          })(<Input placeholder="请输入关键词"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="跳转链接">
          {form.getFieldDecorator('schemeUrl', {
            rules: [{required: true, message: '请输入跳转链接！'}],
            initialValue: formVals.schemeUrl,
          })(<Input placeholder="请输入跳转链接"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="是否热词">
          {form.getFieldDecorator('isHot', {
            initialValue: formVals.isHot + '',
            rules: [{required: true, message: '不能为空！'}],
          })(
            <Select placeholder="请选择" style={{width: '100%'}}>
              {Object.keys(isMap).map(key => (
                <Option key={key}>{isMap[key]}</Option>
              ))}
            </Select>
          )}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="是否显示">
          {form.getFieldDecorator('isShow', {
            initialValue: formVals.isShow + '',
            rules: [{required: true, message: '不能为空！'}],
          })(
            <Select placeholder="请选择" style={{width: '100%'}}>
              {Object.keys(isMap).map(key => (
                <Option key={key}>{isMap[key]}</Option>
              ))}
            </Select>
          )}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="是否默认">
          {form.getFieldDecorator('isDefault', {
            initialValue: formVals.isDefault + '',
            rules: [{required: true, message: '不能为空！'}],
          })(
            <Select placeholder="请选择" style={{width: '100%'}}>
              {Object.keys(isMap).map(key => (
                <Option key={key}>{isMap[key]}</Option>
              ))}
            </Select>
          )}
        </FormItem>
      </Modal>
    );
  }
}

const CreateForm = Form.create()(props => {
  const {loading, modalVisible, form, handleCreateKeywords, handleModalVisible} = props;

  const okHandle = () => {
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      form.resetFields();
      handleCreateKeywords(fieldsValue);
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
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="关键词">
        {form.getFieldDecorator('keyword', {
          rules: [{required: true, message: '不能为空！'}],
        })(<Input placeholder="请输入关键词"/>)}
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="跳转链接">
        {form.getFieldDecorator('schemeUrl', {
          rules: [{required: true, message: '请输入跳转链接！'}],
        })(<Input placeholder="请输入跳转链接"/>)}
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="是否热词">
        {form.getFieldDecorator('isHot', {
          rules: [{required: true, message: '不能为空！'}],
        })(
          <Select placeholder="请选择" style={{width: '100%'}}>
            {Object.keys(isMap).map(key => (
              <Option key={key}>{isMap[key]}</Option>
            ))}
          </Select>
        )}
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="是否显示">
        {form.getFieldDecorator('isSHow', {
          rules: [{required: true, message: '不能为空！'}],
        })(
          <Select placeholder="请选择" style={{width: '100%'}}>
            {Object.keys(isMap).map(key => (
              <Option key={key}>{isMap[key]}</Option>
            ))}
          </Select>
        )}
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="是否默认">
        {form.getFieldDecorator('isDefault', {
          rules: [{required: true, message: '不能为空！'}],
        })(
          <Select placeholder="请选择" style={{width: '100%'}}>
            {Object.keys(isMap).map(key => (
              <Option key={key}>{isMap[key]}</Option>
            ))}
          </Select>
        )}
      </FormItem>
    </Modal>
  );
});

export default KeywordsList;
