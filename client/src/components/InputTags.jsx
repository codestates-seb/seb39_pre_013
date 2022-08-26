/* eslint-disable jsx-a11y/label-has-associated-control */
import React from 'react';
import styled from 'styled-components';

export default function InputTags() {
  return (
    <Container>
      <label htmlFor="tags">
        Tags
        <div>
          <p>Add up to 5 tags to describe what your question is about</p>
        </div>
      </label>
      <input
        id="tags"
        type="text"
        placeholder="e.g. (ruby-onrails .net sql-server)"
      />
    </Container>
  );
}

const Container = styled.section`
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
