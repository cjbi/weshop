import {createGoodsIssue, deleteGoodsIssue, queryGoodsIssue, updateGoodsIssue,} from '@/services/api';

export default {
  namespace: 'goodsIssue',

  state: {
    list: [],
    pagination: {},
    extra: {gender: {}, userLevel: {}},
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryGoodsIssue, payload);
      yield put({
        type: 'save',
        payload: response,
      });
    },
    * create({payload, callback}, {call}) {
      const response = yield call(createGoodsIssue, payload);
      if (callback) callback(response);
    },
    * update({payload, callback}, {call, put}) {
      const response = yield call(updateGoodsIssue, payload);
      if (callback) callback(response);
    },
    * delete({payload, callback}, {call}) {
      const response = yield call(deleteGoodsIssue, payload);
      if (callback) callback(response);
    },
  },

  reducers: {
    save(state, action) {
      return {
        ...state,
        ...action.payload.data,
      };
    },
  },
};
