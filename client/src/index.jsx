import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
// eslint-disable-next-line function-paren-newline
root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>,
  // eslint-disable-next-line function-paren-newline
);
