import React from 'react';
import styled from 'styled-components';
import UserInfo from './UserInfo';

export default function QuestionMenu() {
  return (
    <Container>
      <div>
        <button type="button">Share</button>
        <button type="button">Edit</button>
        <button type="button">Follow</button>
      </div>
      <UserInfo />
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  justify-content: space-between;
  button {
    margin-right: 8px;
    background-color: transparent;
    border: none;
    font-size: 13px;
    color: #acb3b9;
    cursor: pointer;
  }
`;
