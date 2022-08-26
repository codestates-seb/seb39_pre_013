import React from 'react';
import styled, { css } from 'styled-components';

export default function Button(props) {
  // eslint-disable-next-line react/destructuring-assignment
  return <Container onClick={props.onClickHandler}>{props.children}</Container>;
}

const Container = styled.button`
  background-color: #0964aa;
  color: hsl(0, 0%, 100%);
  padding: 0.8rem;
  font-size: 13px;
  cursor: pointer;
  border: none;
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid transparent;
  border-radius: 3px;
`;
