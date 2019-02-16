import React, {Fragment, PureComponent} from 'react';
import {connect} from 'dva';
import {Button, Card, Col, Divider, Form, Icon, Input, message, Modal, Row, Upload} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './BrandList.less';

const FormItem = Form.Item;

@connect(({brand, loading}) => ({
  brand,
  loading: loading.models.brand,
}))
@Form.create()
class BrandList extends PureComponent {
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
      title: '品牌商ID',
      dataIndex: 'id',
    },
    {
      title: '品牌商名称',
      dataIndex: 'name',
    },
    {
      title: '品牌商图片',
      dataIndex: 'picUrl',
      render: text => (
        <a href={text} target="_blank">
          <img src={text} width={65}/>
        </a>
      ),
    },
    {
      title: '介绍',
      dataIndex: 'simpleDesc',
    },
    {
      title: '底价',
      dataIndex: 'floorPrice',
    },
    {
      title: '操作',
      render: (text, record) => (
        <Fragment>
          <a onClick={() => this.handleUpdateModalVisible(true, record)}>修改</a>
          <Divider type="vertical"/>
          <a onClick={() => this.handleDeleteBrand([record.id])}>删除</a>
        </Fragment>
      ),
    },
  ];

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

  handleDeleteBrand = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'brand/delete',
      payload: params,
      callback: response => {
        message.success(response.msg);
        dispatch({type: 'brand/list'});
        this.setState({
          selectedRows: [],
        });
      },
    });
  };

  handleUpdateBrand = fields => {
    const {dispatch} = this.props;
    dispatch({
      type: 'brand/update',
      payload: fields,
      callback: response => {
        message.success(response.msg);
        this.handleUpdateModalVisible();
        dispatch({type: 'brand/list'});
      },
    });
  };

  handleCreateBrand = params => {
    const {dispatch} = this.props;
    dispatch({
      type: 'brand/create',
      payload: params,
      callback: response => {
        message.success(response.msg);
        this.handleModalVisible();
        dispatch({type: 'brand/list'});
      },
    });
  };

  render() {
    const {brand, loading} = this.props;

    const {selectedRows, modalVisible, updateModalVisible, updateFormValues} = this.state;
    const parentMethods = {
      loading,
      handleCreateBrand: this.handleCreateBrand,
      handleModalVisible: this.handleModalVisible,
    };
    const updateMethods = {
      loading,
      handleUpdateModalVisible: this.handleUpdateModalVisible,
      handleUpdateBrand: this.handleUpdateBrand,
    };
    return (
      <PageHeaderWrapper title="行政区域">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <div className={styles.tableListOperator}>
              <Button icon="plus" type="primary" onClick={() => this.handleModalVisible(true)}>
                新建
              </Button>
              {selectedRows.length > 0 && (
                <span>
                  <Button onClick={() => this.handleDeleteBrand(selectedRows.map(row => row.id))}>
                    删除
                  </Button>
                </span>
              )}
            </div>
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
      handleUpdateBrand,
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
        handleUpdateBrand(params);
      });
    };
    return (
      <Modal
        confirmLoading={loading}
        destroyOnClose
        title="修改品牌商"
        visible={updateModalVisible}
        onOk={okHandle}
        onCancel={() => handleUpdateModalVisible()}
      >
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="品牌商名称">
          {form.getFieldDecorator('name', {
            initialValue: formVals.name,
            rules: [{required: true, message: '请输入至少三个字符的用户名！', min: 3}],
          })(<Input placeholder="请输入品牌商名称"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="介绍">
          {form.getFieldDecorator('simpleDesc', {
            initialValue: formVals.simpleDesc,
          })(<Input placeholder="请输入介绍"/>)}
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="品牌商图片">
          {form.getFieldDecorator('picUrl', {
            initialValue: formVals.picUrl,
            rules: [{required: true, message: '品牌商图片是必填的'}],
          })(<Input type="hidden"/>)}
          <Uploader
            accept="image/*"
            imageUrl={formVals.picUrl}
            loading={loading}
            callback={res => {
              form.setFieldsValue({picUrl: res.data});
            }}
          />
        </FormItem>
        <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="底价">
          {form.getFieldDecorator('floorPrice', {
            initialValue: formVals.floorPrice,
          })(<Input type="number" min={0} placeholder="请输入底价"/>)}
        </FormItem>
      </Modal>
    );
  }
}

const CreateForm = Form.create()(props => {
  const {loading, modalVisible, form, handleCreateBrand, handleModalVisible} = props;

  const okHandle = () => {
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      form.resetFields();
      handleCreateBrand(fieldsValue);
    });
  };

  const extractPicUrl = res => {
    form.setFieldsValue({picUrl: res.data});
  };

  const {labelCol, wrapperCol} = {
    labelCol: {span: 5},
    wrapperCol: {span: 15},
  };
  return (
    <Modal
      confirmLoading={loading}
      destroyOnClose
      title="新建品牌商"
      visible={modalVisible}
      onOk={okHandle}
      onCancel={() => handleModalVisible()}
    >
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="品牌商名称">
        {form.getFieldDecorator('name', {
          rules: [{required: true, message: '请输入至少三个字符的用户名！', min: 3}],
        })(<Input placeholder="请输入品牌商名称"/>)}
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="介绍">
        {form.getFieldDecorator('simpleDesc')(<Input placeholder="请输入介绍"/>)}
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="品牌商图片">
        {form.getFieldDecorator('picUrl', {
          rules: [{required: true, message: '品牌商图片是必填的'}],
        })(<Input type="hidden"/>)}
        <Uploader accept="image/*" loading={loading} callback={extractPicUrl}/>
      </FormItem>
      <FormItem labelCol={labelCol} wrapperCol={wrapperCol} label="底价">
        {form.getFieldDecorator('floorPrice')(
          <Input type="number" min={0} placeholder="请输入底价"/>
        )}
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

export default BrandList;
