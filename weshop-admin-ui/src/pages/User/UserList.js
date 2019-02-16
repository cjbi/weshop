import React, {Fragment, PureComponent} from 'react';
import {connect} from 'dva';
import moment from 'moment';
import {Button, Card, Col, DatePicker, Divider, Form, Icon, Input, message, Modal, Row, Select,} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './UserList.less';

const FormItem = Form.Item;

const {Option} = Select;

const CreateForm = Form.create()(props => {
  const {
    loading,
    modalVisible,
    form,
    handleCreateUser,
    handleModalVisible,
    gender,
    userLevel,
  } = props;
  const okHandle = () => {
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      form.resetFields();
      handleCreateUser(fieldsValue);
    });
  };
  return (
    <Modal
      confirmLoading={loading}
      destroyOnClose
      title="新建用户"
      visible={modalVisible}
      onOk={okHandle}
      onCancel={() => handleModalVisible()}
    >
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="用户名">
        {form.getFieldDecorator('username', {
          rules: [{required: true, message: '请输入至少三个字符的用户名！', min: 3}],
        })(<Input placeholder="请输入"/>)}
      </FormItem>
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="手机号">
        {form.getFieldDecorator('mobile', {
          rules: [{required: true, message: '不是有效的手机号！', len: 11}],
        })(<Input placeholder="请输入"/>)}
      </FormItem>
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="密码">
        {form.getFieldDecorator('password', {
          rules: [{required: true, message: '密码不能低于六位数！', min: 6}],
        })(<Input placeholder="请输入"/>)}
      </FormItem>
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="性别">
        {form.getFieldDecorator('gender', {
          rules: [{required: true, message: '性别不能为空！'}],
        })(
          <Select placeholder="请选择" style={{width: '100%'}}>
            {Object.keys(gender).map(key => (
              <Option key={key}>{gender[key]}</Option>
            ))}
          </Select>
        )}
      </FormItem>
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="生日">
        {form.getFieldDecorator('birthday')(
          <DatePicker style={{width: '100%'}} placeholder="请输入生日"/>
        )}
      </FormItem>
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="用户等级">
        {form.getFieldDecorator('userLevelId', {
          rules: [{required: true, message: '需要用户等级！'}],
        })(
          <Select placeholder="请选择" style={{width: '100%'}}>
            {Object.keys(userLevel).map(key => (
              <Option key={key}>{userLevel[key]}</Option>
            ))}
          </Select>
        )}
      </FormItem>
    </Modal>
  );
});

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
      handleUpdate,
      handleUpdateModalVisible,
      gender,
      userLevel,
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
        handleUpdate(params);
      });
    };

    return (
      <Modal
        confirmLoading={loading}
        destroyOnClose
        title="修改用户"
        visible={updateModalVisible}
        onOk={okHandle}
        onCancel={() => handleUpdateModalVisible()}
      >
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="用户名">
          {form.getFieldDecorator('username', {
            initialValue: formVals.username,
            rules: [{required: true, message: '请输入至少三个字符的用户名！', min: 3}],
          })(<Input placeholder="请输入"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="手机号">
          {form.getFieldDecorator('mobile', {
            initialValue: formVals.mobile,
            rules: [{required: true, message: '不是有效的手机号！', len: 11}],
          })(<Input placeholder="请输入"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="性别">
          {form.getFieldDecorator('gender', {
            initialValue: formVals.gender,
            rules: [{required: true, message: '性别不能为空！'}],
          })(
            <Select placeholder="请选择" style={{width: '100%'}}>
              {Object.keys(gender).map(key => (
                <Option key={key}>{gender[key]}</Option>
              ))}
            </Select>
          )}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="生日">
          {form.getFieldDecorator('birthday', {
            initialValue: moment(formVals.birthday),
          })(<DatePicker style={{width: '100%'}} placeholder="请输入生日"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="用户等级">
          {form.getFieldDecorator('userLevelId', {
            initialValue: formVals.userLevelId + '',
            rules: [{required: true, message: '需要用户等级！'}],
          })(
            <Select placeholder="请选择" style={{width: '100%'}}>
              {Object.keys(userLevel).map(key => (
                <Option key={key}>{userLevel[key]}</Option>
              ))}
            </Select>
          )}
        </FormItem>
      </Modal>
    );
  }
}

/* eslint react/no-multi-comp:0 */
@connect(({user1, loading}) => ({
  user1,
  loading: loading.models.user1,
}))
@Form.create()
class UserList extends PureComponent {
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
      title: '用户名',
      dataIndex: 'username',
    },
    {
      title: '手机号码',
      dataIndex: 'mobile',
    },
    {
      title: '性别',
      dataIndex: 'gender',
      render: (text, record) => {
        const {
          user1: {
            extra: {gender},
          },
        } = this.props;
        return gender[text];
      },
    },
    {
      title: '生日',
      dataIndex: 'birthday',
      render: val => <span>{moment(val).format('YYYY-MM-DD')}</span>,
    },
    {
      title: '用户等级',
      dataIndex: 'userLevelId',
      render: (text, record) => {
        const {
          user1: {
            extra: {userLevel},
          },
        } = this.props;
        return userLevel[text];
      },
    },
    {
      title: '操作',
      render: (text, record) => (
        <Fragment>
          <a onClick={() => this.handleUpdateModalVisible(true, record)}>修改</a>
          <Divider type="vertical"/>
          <a onClick={() => this.handleDeleteUser([record.id])}>删除</a>
        </Fragment>
      ),
    },
  ];

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'user1/list',
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
      type: 'user1/list',
      payload: params,
    });
  };

  handleFormReset = () => {
    const {form, dispatch} = this.props;
    form.resetFields();
    this.setState({
      formValues: {},
    });
    dispatch({
      type: 'user1/list',
      payload: {},
    });
  };

  toggleForm = () => {
    const {expandForm} = this.state;
    this.setState({
      expandForm: !expandForm,
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
        type: 'user1/list',
        payload: fieldsValue,
      });
    });
  };

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

  handleCreateUser = fields => {
    const {dispatch} = this.props;
    dispatch({
      type: 'user1/create',
      payload: fields,
      callback: response => {
        message.success(response.msg);
        this.handleModalVisible();
        dispatch({type: 'user1/list'});
      },
    });
  };

  handleUpdate = fields => {
    const {dispatch} = this.props;
    dispatch({
      type: 'user1/update',
      payload: fields,
      callback: response => {
        message.success(response.msg);
        this.handleUpdateModalVisible();
        dispatch({type: 'user1/list'});
      },
    });
  };

  handleDeleteUser = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'user1/delete',
      payload: params,
      callback: response => {
        message.success(response.msg);
        dispatch({type: 'user1/list'});
        this.setState({
          selectedRows: [],
        });
      },
    });
  };

  renderSimpleForm() {
    const {
      form: {getFieldDecorator},
    } = this.props;
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{md: 8, lg: 24, xl: 48}}>
          <Col md={8} sm={24}>
            <FormItem label="用户名">
              {getFieldDecorator('username')(<Input placeholder="请输入"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="手机号">
              {getFieldDecorator('mobile')(<Input placeholder="请输入"/>)}
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
              <a style={{marginLeft: 8}} onClick={this.toggleForm}>
                展开 <Icon type="down"/>
              </a>
            </span>
          </Col>
        </Row>
      </Form>
    );
  }

  renderAdvancedForm() {
    const {
      form: {getFieldDecorator},
      user1: {
        extra: {gender, userLevel},
      },
    } = this.props;
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{md: 8, lg: 24, xl: 48}}>
          <Col md={8} sm={24}>
            <FormItem label="用户名">
              {getFieldDecorator('username')(<Input placeholder="请输入"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="手机号">
              {getFieldDecorator('mobile')(<Input placeholder="请输入"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="性别">
              {getFieldDecorator('gender')(
                <Select placeholder="请选择" style={{width: '100%'}}>
                  {Object.keys(gender).map(key => (
                    <Option key={key}>{gender[key]}</Option>
                  ))}
                </Select>
              )}
            </FormItem>
          </Col>
        </Row>
        <Row gutter={{md: 8, lg: 24, xl: 48}}>
          <Col md={8} sm={24}>
            <FormItem label="用户级别">
              {getFieldDecorator('userLevelId')(
                <Select placeholder="请选择" style={{width: '100%'}}>
                  {Object.keys(userLevel).map(key => (
                    <Option key={key}>{userLevel[key]}</Option>
                  ))}
                </Select>
              )}
            </FormItem>
          </Col>
        </Row>
        <div style={{overflow: 'hidden'}}>
          <div style={{float: 'right', marginBottom: 24}}>
            <Button type="primary" htmlType="submit">
              查询
            </Button>
            <Button style={{marginLeft: 8}} onClick={this.handleFormReset}>
              重置
            </Button>
            <a style={{marginLeft: 8}} onClick={this.toggleForm}>
              收起 <Icon type="up"/>
            </a>
          </div>
        </div>
      </Form>
    );
  }

  renderForm() {
    const {expandForm} = this.state;
    return expandForm ? this.renderAdvancedForm() : this.renderSimpleForm();
  }

  render() {
    const {
      loading,
      user1: {
        extra: {gender, userLevel},
      },
      user1,
    } = this.props;

    const {selectedRows, modalVisible, updateModalVisible, updateFormValues} = this.state;

    const parentMethods = {
      loading,
      handleCreateUser: this.handleCreateUser,
      handleModalVisible: this.handleModalVisible,
      gender: gender,
      userLevel: userLevel,
    };
    const updateMethods = {
      loading,
      handleUpdateModalVisible: this.handleUpdateModalVisible,
      handleUpdate: this.handleUpdate,
      gender: gender,
      userLevel: userLevel,
    };
    return (
      <PageHeaderWrapper title="用户管理">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <div className={styles.tableListOperator}>
              <Button icon="plus" type="primary" onClick={() => this.handleModalVisible(true)}>
                新建
              </Button>
              {selectedRows.length > 0 && (
                <span>
                  <Button onClick={() => this.handleDeleteUser(selectedRows.map(row => row.id))}>
                    删除
                  </Button>
                </span>
              )}
            </div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={user1}
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

export default UserList;
