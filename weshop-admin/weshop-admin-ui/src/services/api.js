import {stringify} from 'qs';
import request from '@/utils/request';


//user
export async function queryAddress(params) {
  return request(`/admin/address/list?${stringify(params)}`);
}

export async function queryCollect(params) {
  return request(`/admin/collect/list?${stringify(params)}`);
}

export async function queryFootprint(params) {
  return request(`/admin/footprint/list?${stringify(params)}`);
}

export async function querySearchHistory(params) {
  return request(`/admin/search-history/list?${stringify(params)}`);
}

export async function queryFeedback(params) {
  return request(`/admin/feedback/list?${stringify(params)}`);
}

export async function queryUser(params) {
  return request(`/admin/user/list?${stringify(params)}`);
}

export async function createUser(params) {
  return request('/admin/user/create', {
    method: 'POST',
    body: params,
  });
}

export async function updateUser(params) {
  return request('/admin/user/update', {
    method: 'POST',
    body: params,
  });
}

export async function deleteUser(params) {
  return request('/admin/user/delete', {
    method: 'POST',
    body: params,
  });
}

//shop
export async function queryRegion(params) {
  return request(`/admin/region/list?${stringify(params)}`);
}

export async function queryBrand(params) {
  return request(`/admin/brand/list?${stringify(params)}`);
}

export async function createBrand(params) {
  return request('/admin/brand/create', {
    method: 'POST',
    body: params,
  });
}

export async function updateBrand(params) {
  return request('/admin/brand/update', {
    method: 'POST',
    body: params,
  });
}

export async function deleteBrand(params) {
  return request('/admin/brand/delete', {
    method: 'POST',
    body: params,
  });
}

export async function queryCategory(params) {
  return request(`/admin/category/list?${stringify(params)}`);
}

export async function createCategory(params) {
  return request('/admin/category/create', {
    method: 'POST',
    body: params,
  });
}

export async function updateCategory(params) {
  return request('/admin/category/update', {
    method: 'POST',
    body: params,
  });
}

export async function deleteCategory(params) {
  return request('/admin/category/delete', {
    method: 'POST',
    body: params,
  });
}

export async function queryOrder(params) {
  return request(`/admin/order/list?${stringify(params)}`);
}

export async function queryOrderDetail(params) {
  return request(`/admin/order/${params}`);
}

export async function queryGoodsIssue(params) {
  return request(`/admin/goods-issue/list?${stringify(params)}`);
}

export async function createGoodsIssue(params) {
  return request('/admin/goods-issue/create', {
    method: 'POST',
    body: params,
  });
}

export async function updateGoodsIssue(params) {
  return request('/admin/goods-issue/update', {
    method: 'POST',
    body: params,
  });
}

export async function deleteGoodsIssue(params) {
  return request('/admin/goods-issue/delete', {
    method: 'POST',
    body: params,
  });
}

export async function queryKeywords(params) {
  return request(`/admin/keywords/list?${stringify(params)}`);
}

export async function createKeywords(params) {
  return request('/admin/keywords/create', {
    method: 'POST',
    body: params,
  });
}

export async function updateKeywords(params) {
  return request('/admin/keywords/update', {
    method: 'POST',
    body: params,
  });
}

export async function deleteKeywords(params) {
  return request('/admin/keywords/delete', {
    method: 'POST',
    body: params,
  });
}

//===================================================

export async function queryProjectNotice() {
  return request('/api/project/notice');
}

export async function queryActivities() {
  return request('/api/activities');
}

export async function queryRule(params) {
  return request(`/api/rule?${stringify(params)}`);
}

export async function removeRule(params) {
  return request('/api/rule', {
    method: 'POST',
    body: {
      ...params,
      method: 'delete',
    },
  });
}

export async function addRule(params) {
  return request('/api/rule', {
    method: 'POST',
    body: {
      ...params,
      method: 'post',
    },
  });
}

export async function updateRule(params) {
  return request('/api/rule', {
    method: 'POST',
    body: {
      ...params,
      method: 'update',
    },
  });
}

export async function fakeSubmitForm(params) {
  return request('/api/forms', {
    method: 'POST',
    body: params,
  });
}

export async function fakeChartData() {
  return request('/api/fake_chart_data');
}

export async function queryTags() {
  return request('/api/tags');
}

export async function queryBasicProfile() {
  return request('/api/profile/basic');
}

export async function queryAdvancedProfile() {
  return request('/api/profile/advanced');
}

export async function queryFakeList(params) {
  return request(`/api/fake_list?${stringify(params)}`);
}

export async function removeFakeList(params) {
  const {count = 5, ...restParams} = params;
  return request(`/api/fake_list?count=${count}`, {
    method: 'POST',
    body: {
      ...restParams,
      method: 'delete',
    },
  });
}

export async function addFakeList(params) {
  const {count = 5, ...restParams} = params;
  return request(`/api/fake_list?count=${count}`, {
    method: 'POST',
    body: {
      ...restParams,
      method: 'post',
    },
  });
}

export async function updateFakeList(params) {
  const {count = 5, ...restParams} = params;
  return request(`/api/fake_list?count=${count}`, {
    method: 'POST',
    body: {
      ...restParams,
      method: 'update',
    },
  });
}

export async function fakeAccountLogin(params) {
  return request('/api/login/account', {
    method: 'POST',
    body: params,
  });
}

export async function fakeRegister(params) {
  return request('/api/register', {
    method: 'POST',
    body: params,
  });
}

export async function queryNotices() {
  return request('/api/notices');
}

export async function getFakeCaptcha(mobile) {
  return request(`/api/captcha?mobile=${mobile}`);
}
