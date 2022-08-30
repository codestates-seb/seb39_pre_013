import React from 'react';
import styled from 'styled-components';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import GlobalStyle from './GlobalStyle';
import AskQuestion from './pages/blxxom/AskQuestion';
import DetailQuestion from './pages/blxxom/DetailQuestion';

function App() {
  return (
    <>
      <Container className="App">
        <BrowserRouter>
          <main>
            <Routes>
              <Route path="/" element={<AskQuestion />} />
              <Route path="detail" element={<DetailQuestion />} />
            </Routes>
          </main>
        </BrowserRouter>
      </Container>
      <GlobalStyle />
    </>
  );
}

const Container = styled.div`
  margin-right: 0 auto;
  main {
    max-width: 1024px;
    margin: 0 auto;
  }
`;

export default App;
