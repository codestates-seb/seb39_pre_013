/* eslint-disable react/destructuring-assignment */
/* eslint-disable react/jsx-curly-newline */
/* eslint-disable implicit-arrow-linebreak */
/* eslint function-paren-newline: ["error", "never"] */
import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import ReactMde from 'react-mde';
import Markdown from './Markdown';
import 'react-mde/lib/styles/css/react-mde-all.css';

export default React.memo((props) => {
  const [value, setValue] = useState('');
  console.log('value :', value, typeof value);
  useEffect(() => {
    // eslint-disable-next-line no-return-assign, no-param-reassign
    props.setEditorValue(value);
  }, [props, value]);

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
});

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
