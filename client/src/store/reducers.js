/* eslint-disable no-undef */
/* eslint-disable import/prefer-default-export */
/* eslint-disable no-param-reassign */
import { createSlice } from "@reduxjs/toolkit";
import { PURGE } from "redux-persist";
import storage from "redux-persist/lib/storage";

const initState = {userInfo: ''};

export const loginSlice = createSlice({
    name: 'loginState',
    initialState: initState,
    reducers: {
        loginActions: (state, action) => {
            state.userInfo = action.payload;
        },

        logoutActions: (state) => {
            state.userInfo = initState;
        },

        getState: (state) => {
            // eslint-disable-next-line no-unused-expressions
            state.userInfo;
        }
    },
});

export const {loginActions, logoutActions, getState} = loginSlice.actions;
export default loginSlice.reducer;