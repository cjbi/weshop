import {querySearchHistory} from '@/services/api';

export default {
  namespace: 'searchHistory',
  state: {
    list: [],
    pagination: {}
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(querySearchHistory, payload);
      yield put({
        type: 'queryList',
        payload: response,
      });
    },
  },

  reducers: {
    queryList(state, action) {
      return {
        ...state,
        ...action.payload.data,
      };
    },
  },
};
