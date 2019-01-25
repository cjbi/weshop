import {createCategory, deleteCategory, queryCategory, updateCategory} from '@/services/api';

export default {
  namespace: 'category',

  state: {
    list: [],
    pagination: {},
    extra: {categoryLevel: {}, l1: []},
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryCategory, payload);
      yield put({
        type: 'save',
        payload: response,
      });
    },
    * create({payload, callback}, {call}) {
      const response = yield call(createCategory, payload);
      if (callback) callback(response);
    },
    * update({payload, callback}, {call, put}) {
      const response = yield call(updateCategory, payload);
      if (callback) callback(response);
    },
    * delete({payload, callback}, {call}) {
      const response = yield call(deleteCategory, payload);
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
