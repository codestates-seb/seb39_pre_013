import React, { useEffect, useState } from 'react';
import { Reset } from 'styled-reset';
import axios from 'axios';
import styled, { createGlobalStyle } from 'styled-components';
import Main from './pages/Main';
import Header from './components/Header';
import QuestionsSection from './components/QuestionsSection';

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
  // let data = null;

  // const fetchData = () => {
  //   axios.get('https://api.stackexchange.com/2.3/questions?page=1&pagesize=1&order=desc&sort=activity&site=stackoverflow&filter=!nKzQUR30SM')
  //     .then((response) => {
  //       data = response;
  //     });
  // };

  // useEffect(() => fetchData());
  // if (data !== null) console.log(data);

  return (
    <div>
      <Reset />
      <GlobalStyles />
      <Header />
      <QuestionsSection />
    </div>
  );
}

export default App;
