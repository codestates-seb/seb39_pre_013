/* eslint-disable import/prefer-default-export */
import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { QueryClient, QueryClientProvider } from 'react-query';
import { Provider } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import { persistStore } from 'redux-persist';
import App from './App';
import store from './store/index';

const queryClient = new QueryClient();
export const persistor = persistStore(store);

const root = ReactDOM.createRoot(document.getElementById('root'));
// eslint-disable-next-line function-paren-newline
root.render(
  <QueryClientProvider client={queryClient}>
    <BrowserRouter>
      <Provider store={store}>
        <PersistGate loading={null} persistor={persistor}>
          <App />
        </PersistGate>
      </Provider>
    </BrowserRouter>
  </QueryClientProvider>,
  // eslint-disable-next-line function-paren-newline
);
