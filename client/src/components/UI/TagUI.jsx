/* eslint-disable react/destructuring-assignment */
import React from 'react';
import styled from 'styled-components';

export default function TagUI(props) {
  return <Container>{props.children}</Container>;
}

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 13px;
  border-radius: 3px;
  color: hsl(205, 46.5%, 73.5%);
  background-color: hsl(205, 14%, 28%);
  line-height: 1.84615385;
  vertical-align: middle;
  padding: 0.1rem 0.3rem;
`;
