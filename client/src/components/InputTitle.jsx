/* eslint-disable jsx-a11y/label-has-associated-control */
import React from 'react';
import styled from 'styled-components';

export default function InputTitle() {
  return (
    <Container>
      <label htmlFor="title">
        Title
        <div>
          <p>
            Be specific and imagine you’re asking a question to another person
          </p>
        </div>
      </label>
      <input
        id="title"
        type="text"
        placeholder="e.g Is there an R function for finding the index of an element in a vector?"
      />
    </Container>
  );
}

const Container = styled.section`
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 8px;
  label {
    cursor: pointer;
    font-size: 1.15384615rem;

    p {
      font-size: 12px;
    }
  }

  input {
    padding: 0.6rem 0.7rem;
    border-radius: 3px;
    font-size: 13px;
    color: hsl(210, 4%, 95%);
    outline: none;
    background-color: hsl(0, 0%, 17.5%);
  }
`;
