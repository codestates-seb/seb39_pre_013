/* eslint-disable react/jsx-curly-newline */
/* eslint-disable implicit-arrow-linebreak */
/* eslint function-paren-newline: ["error", "never"] */
import React, { useState } from 'react';
import styled from 'styled-components';
import ReactMde from 'react-mde';
import Markdown from './Markdown';
import 'react-mde/lib/styles/css/react-mde-all.css';

export default function Editor() {
  const [value, setValue] = useState('');

  return (
    <Container>
      <ReactMde value={value} onChange={setValue} />
      <div>
        <ListContainer>
          <li>```code```</li>
          <li>**bold**</li>
          <li>*italic*</li>
          <li>&gt;quote</li>
        </ListContainer>
      </div>
      <Markdown text={value} />
    </Container>
  );
}

const ListContainer = styled.ul`
  display: flex;
  gap: 0.4rem;

  li {
    list-style: none;
  }
`;

const Container = styled.div`
  .mde-header {
    background-color: #2d2d2d;
    button {
      color: white;
    }
  }

  path {
    fill: hsl(210, 4%, 95%);
  }

  .mde-text {
    background-color: #2d2d2d;
    color: hsl(210, 4%, 95%);
  }
`;
