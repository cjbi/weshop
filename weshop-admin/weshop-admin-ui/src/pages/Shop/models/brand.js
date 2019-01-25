import {createBrand, deleteBrand, queryBrand, updateBrand} from '@/services/api';

export default {
  namespace: 'brand',

  state: {
    list: [],
    pagination: {},
    extra: {gender: {}, userLevel: {}},
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryBrand, payload);
      yield put({
        type: 'save',
        payload: response,
      });
    },
    * create({payload, callback}, {call}) {
      const response = yield call(createBrand, payload);
      if (callback) callback(response);
    },
    * update({payload, callback}, {call, put}) {
      const response = yield call(updateBrand, payload);
      if (callback) callback(response);
    },
    * delete({payload, callback}, {call}) {
      const response = yield call(deleteBrand, payload);
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
