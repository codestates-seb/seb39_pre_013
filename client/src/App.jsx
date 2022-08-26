import React from 'react';
import styled from 'styled-components';
import GlobalStyle from './GlobalStyle';
import AskQuestion from './pages/blxxom/AskQuestion';

function App() {
  return (
    <>
      <Container className="App">
        <main>
          <AskQuestion />
        </main>
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
