import {createKeywords, deleteKeywords, queryKeywords, updateKeywords} from '@/services/api';

export default {
  namespace: 'keywords',

  state: {
    list: [],
    pagination: {},
    extra: {gender: {}, userLevel: {}},
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryKeywords, payload);
      yield put({
        type: 'save',
        payload: response,
      });
    },
    * create({payload, callback}, {call}) {
      const response = yield call(createKeywords, payload);
      if (callback) callback(response);
    },
    * update({payload, callback}, {call, put}) {
      const response = yield call(updateKeywords, payload);
      if (callback) callback(response);
    },
    * delete({payload, callback}, {call}) {
      const response = yield call(deleteKeywords, payload);
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
