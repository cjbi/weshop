import React, {PureComponent} from 'react';
import {connect} from 'dva';
import {
  Card,
  Form,
  Button, Row, Col, Input, Modal, message, Upload, Icon,
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

  handleModalVisible = flag => {
    this.setState({
      modalVisible: !!flag,
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
  }


  render() {
    const {
      brand,
      loading,
    } = this.props;

    const {selectedRows, modalVisible, updateModalVisible, updateFormValues} = this.state;
    const parentMethods = {
      loading,
      handleCreateBrand: this.handleCreateBrand,
      handleModalVisible: this.handleModalVisible,
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
          <CreateForm {...parentMethods} modalVisible={modalVisible}/>
        </Card>
      </PageHeaderWrapper>
    );

  }
}

const CreateForm = Form.create()(props => {
  const {loading, modalVisible, form, handleCreateBrand, handleModalVisible} = props;

  const okHandle = () => {

  };
  const uploadButton = (
    <div>
      <Icon type={loading ? 'loading' : 'plus'}/>
      <div className="ant-upload-text">上传</div>
    </div>
  );
  const imageUrl = null;
  return (
    <Modal
      confirmLoading={loading}
      destroyOnClose
      title="新建品牌商"
      visible={modalVisible}
      onOk={okHandle}
      onCancel={() => handleModalVisible()}
    >
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="品牌商名称">
        {form.getFieldDecorator('name', {
          rules: [{required: true, message: '请输入至少三个字符的用户名！', min: 3}],
        })(<Input placeholder="请输入品牌商名称"/>)}
      </FormItem>
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="介绍">
        {form.getFieldDecorator('simpleDesc')(<Input placeholder="请输入介绍"/>)}
      </FormItem>
      <FormItem labelCol={{span: 5}} wrapperCol={{span: 15}} label="品牌商图片">
        <Upload
          name="picUrl"
          listType="picture-card"
          className="avatar-uploader"
          showUploadList={false}
        >
          {imageUrl ? <img src={imageUrl} alt="avatar"/> : uploadButton}
        </Upload>
      </FormItem>
    </Modal>)
});

function getBase64(img, callback) {
  const reader = new FileReader();
  reader.addEventListener('load', () => callback(reader.result));
  reader.readAsDataURL(img);
}

function beforeUpload(file) {
  const isJPG = file.type === 'image/jpeg';
  if (!isJPG) {
    message.error('You can only upload JPG file!');
  }
  const isLt2M = file.size / 1024 / 1024 < 2;
  if (!isLt2M) {
    message.error('Image must smaller than 2MB!');
  }
  return isJPG && isLt2M;
}

class AvatarUploader extends React.Component {
  state = {
    loading: false,
  };

  handleChange = (info) => {
    if (info.file.status === 'uploading') {
      this.setState({ loading: true });
      return;
    }
    if (info.file.status === 'done') {
      // Get this url from response in real world.
      getBase64(info.file.originFileObj, imageUrl => this.setState({
        imageUrl,
        loading: false,
      }));
    }
  }

  render() {
    const uploadButton = (
      <div>
        <Icon type={this.state.loading ? 'loading' : 'plus'} />
        <div className="ant-upload-text">Upload</div>
      </div>
    );
    const imageUrl = this.state.imageUrl;
    return (
      <Upload
        name="avatar"
        listType="picture-card"
        className="avatar-uploader"
        showUploadList={false}
        action="//jsonplaceholder.typicode.com/posts/"
        beforeUpload={beforeUpload}
        onChange={this.handleChange}
      >
        {imageUrl ? <img src={imageUrl} alt="avatar" /> : uploadButton}
      </Upload>
    );
  }
}


export default BrandList;
