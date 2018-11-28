import {queryAddress} from '@/services/api';

export default {
  namespace: 'address',
  state: {
    list: [],
    pagination: {}
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryAddress, payload);
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
