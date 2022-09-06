/* eslint-disable react/destructuring-assignment */
/* eslint-disable react/button-has-type */
import React from 'react';
import styled from 'styled-components';

export default function Tags(props) {
  const deleteTagHandler = (e) => {
    e.preventDefault();
    const findTag = props.tags.indexOf(props.children);
    props.setTag((prev) => prev.filter((_, i) => i !== findTag));
  };
  return (
    <Container>
      {props.children}
      <button onClick={deleteTagHandler}>x</button>
    </Container>
  );
}

const Container = styled.span`
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 13px;
  border-radius: 3px;
  color: hsl(205, 46.5%, 73.5%);
  background-color: hsl(205, 14%, 28%);
  line-height: 1.84615385;
  vertical-align: middle;
  padding: 0 4px;

  button {
    border: none;
    background-color: transparent;
    color: hsl(205, 46.5%, 73.5%);
    cursor: pointer;
    margin-left: 5px;
    padding: 1px;
    width: 1rem;
    height: 1rem;
    &:hover {
      background-color: hsl(205, 46.5%, 73.5%);
      color: hsl(205, 14%, 28%);
      border-radius: 3px;
    }
  }
`;
