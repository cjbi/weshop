import {queryRegion} from '@/services/api';

export default {
  namespace: 'region',

  state: {
    list: [],
    pagination: {},
    extra: {regionType: {}},
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryRegion, payload);
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
