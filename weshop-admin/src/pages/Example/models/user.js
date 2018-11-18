import { queryUser, removeRule, createUser, updateUser } from '@/services/api';

export default {
  namespace: 'user1',

  state: {
    data: {
      list: [],
      pagination: {},
      extra: { gender: {}, userLevel: {} },
    },
  },

  effects: {
    *list({ payload }, { call, put }) {
      const response = yield call(queryUser, payload);
      yield put({
        type: 'save',
        payload: response,
      });
    },
    *create({ payload, callback }, { call, put }) {
      const response = yield call(createUser, payload);
      // yield put({
      //   type: 'save',
      //   payload: response,
      // });
      if (callback) callback(response);
    },
    *remove({ payload, callback }, { call, put }) {
      const response = yield call(removeRule, payload);
      // yield put({
      //   type: 'save',
      //   payload: response,
      // });
      if (callback) callback();
    },
    *update({ payload, callback }, { call, put }) {
      const response = yield call(updateUser, payload);
      // yield put({
      //   type: 'save',
      //   payload: response,
      // });
      if (callback) callback(response);
    },
  },

  reducers: {
    save(state, action) {
      console.log('--------------------------');
      console.log(state);
      console.log(action);
      console.log('--------------------------');
      return {
        ...state,
        data: action.payload.data,
      };
    },
  },
};
