import React, {Fragment, PureComponent} from 'react';
import {connect} from 'dva';
import {Button, Card, Col, Divider, Form, Icon, Input, message, Modal, Row, Select, Upload,} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './CategoryList.less';

const FormItem = Form.Item;

@connect(({category, loading}) => ({
  category,
  loading: loading.models.category,
}))
@Form.create()
class CategoryList extends PureComponent {
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
      title: '类目ID',
      dataIndex: 'id',
    },
    {
      title: '类目名称',
      dataIndex: 'name',
    },
    {
      title: '类目图标',
      dataIndex: 'iconUrl',
      render: text => (
        <a href={text} target="_blank">
          <img src={text} width={65}/>
        </a>
      ),
    },
    {
      title: '类目图片',
      dataIndex: 'imgUrl',
      render: text => (
        <a href={text} target="_blank">
          <img src={text} width={65}/>
        </a>
      ),
    },
    {
      title: '关键词',
      dataIndex: 'keywords',
    },
    {
      title: '简介',
      dataIndex: 'frontDesc',
    },
    {
      title: '类别',
      dataIndex: 'level',
      render: text => {
        const {
          category: {
            extra: {categoryLevel},
          },
        } = this.props;
        return categoryLevel[text];
      },
    },
    {
      title: '父类目ID',
      dataIndex: 'parentId',
    },
    {
      title: '操作',
      render: (text, record) => (
        <Fragment>
          <a onClick={() => this.handleUpdateModalVisible(true, record)}>修改</a>
          <Divider type="vertical"/>
          <a onClick={() => this.handleDeleteCategory([record.id])}>删除</a>
        </Fragment>
      ),
    },
  ];

  componentDidMount() {
    const {dispatch} = this.props;
    dispatch({
      type: 'category/list',
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
      type: 'category/list',
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
        type: 'category/list',
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
      type: 'category/list',
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
            <FormItem label="类目ID">
              {getFieldDecorator('id')(<Input placeholder="请输入类目ID"/>)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="类目名称">
              {getFieldDecorator('name')(<Input placeholder="请输入类目名称"/>)}
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

  handleDeleteCategory = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'category/delete',
      payload: params,
      callback: response => {
        message.success(response.msg);
        dispatch({type: 'category/list'});
        this.setState({
          selectedRows: [],
        });
      },
    });
  };

  handleUpdateCategory = fields => {
    const {dispatch} = this.props;
    dispatch({
      type: 'category/update',
      payload: fields,
      callback: response => {
        message.success(response.msg);
        this.handleUpdateModalVisible();
        dispatch({type: 'category/list'});
      },
    });
  };

  handleCreateCategory = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'category/create',
      payload: params,
      callback: response => {
        message.success(response.msg);
        this.handleModalVisible();
        dispatch({type: 'category/list'});
      },
    });
  };

  render() {
    const {
      category,
      loading,
      category: {
        extra: {categoryLevel, l1},
      },
    } = this.props;
    const {selectedRows, modalVisible, updateModalVisible, updateFormValues} = this.state;
    const parentMethods = {
      loading,
      handleCreateCategory: this.handleCreateCategory,
      handleModalVisible: this.handleModalVisible,
      categoryLevel: categoryLevel,
      l1: l1,
    };
    const updateMethods = {
      loading,
      handleUpdateModalVisible: this.handleUpdateModalVisible,
      handleUpdateCategory: this.handleUpdateCategory,
      categoryLevel: categoryLevel,
      l1: l1,
    };
    return (
      <PageHeaderWrapper title="商品类目">
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
                    onClick={() => this.handleDeleteCategory(selectedRows.map(row => row.id))}
                  >
                    删除
                  </Button>
                </span>
              )}
            </div>
            <StandardTable
              selectedRows={selectedRows}
              loading={loading}
              data={category}
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
      handleUpdateCategory,
      handleUpdateModalVisible,
      categoryLevel,
      l1,
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
        handleUpdateCategory(params);
      });
    };
    return (
      <Modal
        confirmLoading={loading}
        destroyOnClose
        title="修改类目"
        visible={updateModalVisible}
        onOk={okHandle}
        onCancel={() => handleUpdateModalVisible()}
      >
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="类目名称">
          {form.getFieldDecorator('name', {
            rules: [{required: true, message: '请输入至少三个字符的用户名！', min: 3}],
            initialValue: formVals.name,
          })(<Input placeholder="请输入类目名称"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="关键字">
          {form.getFieldDecorator('keywords', {initialValue: formVals.keywords})(
            <Input placeholder="请输入关键字"/>
          )}
        </FormItem>
        <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="级别">
          {form.getFieldDecorator('level', {
            rules: [{required: true, message: '级别不能为空！'}],
            initialValue: formVals.level,
          })(
            <Select placeholder="请选择" style={{width: '100%'}}>
              {Object.keys(categoryLevel).map(key => (
                <Option key={key}>{categoryLevel[key]}</Option>
              ))}
            </Select>
          )}
        </FormItem>
        {form.getFieldValue('level') === 'L2' ? (
          <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="父类目">
            {form.getFieldDecorator('parentId', {
              rules: [{required: true, message: '父类目不能为空！'}],
              initialValue: formVals.parentId + '',
            })(
              <Select placeholder="请选择" style={{width: '100%'}}>
                {l1.map(item => (
                  <Option key={item.id}>{item.name}</Option>
                ))}
              </Select>
            )}
          </FormItem>
        ) : null}
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="类目图标">
          {form.getFieldDecorator('iconUrl', {initialValue: formVals.iconUrl})(
            <Input type="hidden"/>
          )}
          <Uploader
            accept="image/*"
            loading={loading}
            imageUrl={formVals.iconUrl}
            callback={res => form.setFieldsValue({iconUrl: res.data})}
          />
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="类目图图片">
          {form.getFieldDecorator('imgUrl', {initialValue: formVals.imgUrl})(
            <Input type="hidden"/>
          )}
          <Uploader
            accept="image/*"
            loading={loading}
            imageUrl={formVals.imgUrl}
            callback={res => form.setFieldsValue({imgUrl: res.data})}
          />
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="类目简介">
          {form.getFieldDecorator('frontDesc', {initialValue: formVals.frontDesc})(
            <Input placeholder="请输入类目简介"/>
          )}
        </FormItem>
      </Modal>
    );
  }
}

const CreateForm = Form.create()(props => {
  const {
    loading,
    modalVisible,
    form,
    handleCreateCategory,
    handleModalVisible,
    categoryLevel,
    l1,
  } = props;
  const okHandle = () => {
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      form.resetFields();
      handleCreateCategory(fieldsValue);
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
      title="新建类目"
      visible={modalVisible}
      onOk={okHandle}
      onCancel={() => handleModalVisible()}
    >
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="类目名称">
        {form.getFieldDecorator('name', {
          rules: [{required: true, message: '请输入至少三个字符的用户名！', min: 3}],
        })(<Input placeholder="请输入类目名称"/>)}
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="关键字">
        {form.getFieldDecorator('keywords')(<Input placeholder="请输入关键字"/>)}
      </FormItem>
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="级别">
        {form.getFieldDecorator('level', {
          rules: [{required: true, message: '级别不能为空！'}],
          initialValue: 'L2',
        })(
          <Select placeholder="请选择" style={{width: '100%'}}>
            {Object.keys(categoryLevel).map(key => (
              <Option key={key}>{categoryLevel[key]}</Option>
            ))}
          </Select>
        )}
      </FormItem>
      {form.getFieldValue('level') === 'L2' ? (
        <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="父类目">
          {form.getFieldDecorator('parentId', {
            rules: [{required: true, message: '父类目不能为空！'}],
          })(
            <Select placeholder="请选择" style={{width: '100%'}}>
              {l1.map(item => (
                <Option key={item.id}>{item.name}</Option>
              ))}
            </Select>
          )}
        </FormItem>
      ) : null}
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="类目图标">
        {form.getFieldDecorator('iconUrl')(<Input type="hidden"/>)}
        <Uploader
          accept="image/*"
          loading={loading}
          callback={res => form.setFieldsValue({iconUrl: res.data})}
        />
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="类目图图片">
        {form.getFieldDecorator('imgUrl')(<Input type="hidden"/>)}
        <Uploader
          accept="image/*"
          loading={loading}
          callback={res => form.setFieldsValue({imgUrl: res.data})}
        />
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="类目简介">
        {form.getFieldDecorator('frontDesc')(<Input placeholder="请输入类目简介"/>)}
      </FormItem>
    </Modal>
  );
});

// 自定义上传组件Uploder
const action = '//localhost:8080/storage/upload';

const getBase64 = (img, callback) => {
  const reader = new FileReader();
  reader.addEventListener('load', () => callback(reader.result));
  reader.readAsDataURL(img);
};

const beforeUpload = file => {
  const isJPG = file.type === 'image/jpeg';
  if (!isJPG) {
    message.error('You can only upload JPG file!');
  }
  const isLt2M = file.size / 1024 / 1024 < 2;
  if (!isLt2M) {
    message.error('Image must smaller than 2MB!');
  }
  return isJPG && isLt2M;
};

class Uploader extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      imageUrl: props.imageUrl,
      loading: props.loading,
    };
  }

  handleChange = info => {
    const {callback} = this.props;

    if (info.file.status === 'uploading') {
      this.setState({loading: true});
      return;
    }
    if (info.file.status === 'done') {
      // Get this url from response in real world.
      getBase64(info.file.originFileObj, imageUrl =>
        this.setState({
          imageUrl,
          loading: false,
        })
      );
      callback(info.file.response);
    }
  };

  render() {
    const uploadButton = (
      <div>
        <Icon type={this.state.loading ? 'loading' : 'plus'}/>
        <div className="ant-upload-text">上传图片</div>
      </div>
    );

    const imageUrl = this.state.imageUrl;
    return (
      <Upload
        {...this.props}
        name="file"
        listType="picture-card"
        className="avatar-uploader"
        showUploadList={false}
        action={action}
        beforeUpload={beforeUpload}
        onChange={this.handleChange}
      >
        {imageUrl ? <img src={imageUrl} style={{width: '150px'}} alt="avatar"/> : uploadButton}
      </Upload>
    );
  }
}

export default CategoryList;
