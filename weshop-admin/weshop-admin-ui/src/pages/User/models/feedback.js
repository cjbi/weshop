import {queryFeedback} from '@/services/api';

export default {
  namespace: 'feedback',
  state: {
    list: [],
    pagination: {}
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryFeedback, payload);
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
