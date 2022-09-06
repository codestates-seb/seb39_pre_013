/* eslint-disable react/destructuring-assignment */
import React from 'react';
import styled from 'styled-components';
import UserInfo from '../Common/UserInfo';

/**
 *
 * @Todo redux || recoil 사용으로 전역 데이터 관리 필요
 */

export default function QuestionMenu(props) {
  return (
    <Container>
      <div>
        <button type="button">Share</button>
        <button type="button">Edit</button>
        <button type="button">Follow</button>
      </div>
      <UserInfo info={props.owner} />
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  justify-content: space-between;
  margin: 1rem 0;
  button {
    margin-right: 8px;
    background-color: transparent;
    border: none;
    font-size: 13px;
    color: #acb3b9;
    cursor: pointer;
  }
`;
