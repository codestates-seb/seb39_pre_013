import React from 'react';
import { Reset } from 'styled-reset';

import styled, { createGlobalStyle } from 'styled-components';
import Header from './components/Header';
import Questions from './components/Qustions';

const GlobalStyles = createGlobalStyle`
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');
  body{
    background: #2d2d2d;
    color: #fff;
    font-family: Roboto, sans-serif;
    font-size: 20px;
  }
`;

function App() {
  return (
    <div>
      <Reset />
      <GlobalStyles />
      <Header />
      <Questions />
    </div>
  );
}

export default App;
