import {createUser, deleteUser, queryUser, updateUser} from '@/services/api';

export default {
  namespace: 'user1',

  state: {
    list: [],
    pagination: {},
    extra: {gender: {}, userLevel: {}},
  },

  effects: {
    * list({payload}, {call, put}) {
      const response = yield call(queryUser, payload);
      yield put({
        type: 'save',
        payload: response,
      });
    },
    * create({payload, callback}, {call}) {
      const response = yield call(createUser, payload);
      if (callback) callback(response);
    },
    * delete({payload, callback}, {call}) {
      const response = yield call(deleteUser, payload);
      // yield put({
      //   type: 'save',
      //   payload: response,
      // });
      if (callback) callback(response);
    },
    * update({payload, callback}, {call, put}) {
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
      return {
        ...state,
        ...action.payload.data,
      };
    },
  },
};
