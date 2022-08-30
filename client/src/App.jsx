import React from 'react';
import styled from 'styled-components';
import { Reset } from 'styled-reset';
import { Routes, Route, Navigate } from 'react-router-dom';
import GlobalStyle from './GlobalStyle';
import AskQuestion from './pages/AskQuestion';
import Header from './components/Common/Header';
import NavBar from './components/Common/NavBar';
import QuestionsSection from './pages/QuestionsSection';

function App() {
  return (
    <>
      <Header />
      <Container>
        <NavBar />
        <main>
          <Routes>
            <Route path="/" element={<QuestionsSection />} />
            <Route path="/askquestion" element={<AskQuestion />} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Routes>
        </main>
      </Container>

      <Reset />
      <GlobalStyle />
    </>
  );
}

const Container = styled.div`
  /* display: flex; */
`;

export default App;

// {/* <Container className="App">
//         <BrowserRouter>
//           <main>
//             <Routes>
//               <Route path="/" element={<AskQuestion />} />
//               <Route path="detail" element={<DetailQuestion />} />
//             </Routes>
//           </main>
//         </BrowserRouter>
//       </Container> */}
