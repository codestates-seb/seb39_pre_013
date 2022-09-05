/* eslint-disable function-paren-newline */
import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { Routes, Route, Navigate } from 'react-router-dom';
import GlobalStyle from './GlobalStyle';
import AskQuestion from './pages/AskQuestion';
import Header from './components/Common/Header';
import NavBar from './components/Common/NavBar';
import QuestionsSection from './pages/QuestionsSection';
import DetailQuestion from './pages/DetailQuestion';
import UsersPage from './pages/UsersPage';
import LoginPage from './pages/LoginPage';

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
            <Route path="/question/:id" element={<DetailQuestion />} />
            <Route path="/users" element={<UsersPage />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Routes>
        </main>
      </Container>
      <GlobalStyle />
    </>
  );
}

const Container = styled.div`
  display: flex;
  justify-content: center;
  margin: auto;
  max-width: 1280px;
  position: relative;
  main {
    width: 100%;
  }
`;

export default App;
