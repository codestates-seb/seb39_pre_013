import React from 'react';
import styled from 'styled-components';

export default function QuestionMenu() {
  return (
    <Container>
      <button type="button">Share</button>
      <button type="button">Edit</button>
      <button type="button">Follow</button>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  gap: 12px;

  button {
    background-color: transparent;
    border: none;
    font-size: 13px;
    color: #acb3b9;
    cursor: pointer;
  }
`;
