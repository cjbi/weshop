import {queryCollect} from '@/services/api';

export default {
  namespace: 'collect',
  state: {
    data: {
      list: [],
      pagination: {}
    },
  },

  effects: {
    *list({payload}, {call, put}) {
      const response = yield call(queryCollect, payload);
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
        data: action.payload.data,
      };
    },
  },
};
