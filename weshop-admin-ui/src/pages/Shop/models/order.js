import {queryOrder, queryOrderDetail} from '@/services/api';

export default {
  namespace: 'order',

  state: {
    list: [],
    pagination: {},
    extra: {regionType: {}},
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryOrder, payload);
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
