import {queryFootprint} from '@/services/api';

export default {
  namespace: 'footprint',
  state: {
    list: [],
    pagination: {}
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryFootprint, payload);
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
