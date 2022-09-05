/* eslint-disable no-shadow */
/* eslint-disable no-param-reassign */
import { combineReducers, configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import { persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';
import loginReducer from './reducers';

const reducers = combineReducers({
    loginState: loginReducer
});


const persistConfig = {
    key: 'root',
    storage
};

const persistedReducer = persistReducer(persistConfig, reducers);

const store = configureStore({
    reducer: persistedReducer,
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({serializableCheck: false})
});

export default store;