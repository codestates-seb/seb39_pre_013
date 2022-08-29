/* eslint-disable jsx-a11y/label-has-associated-control */
import React, { useState } from 'react';
import styled from 'styled-components';
import Tags from './UI/Tags';

export default function InputTags() {
  const [tagList, setTagList] = useState([]);
  const [tagInputValue, setTagInputValue] = useState('');

  const tagInputHandler = (e) => {
    const inputValue = e.target.value;
    if (inputValue.includes(' ')) {
      if (inputValue.length === 1) {
        return;
      }
      if (tagList.includes(inputValue)) {
        setTagInputValue('');
        return;
      }
      setTagInputValue('');
      setTagList((prev) => [...prev, inputValue]);
    } else {
      setTagInputValue(inputValue);
    }
  };

  // eslint-disable-next-line consistent-return
  const editTagHandler = (e) => {
    if (tagList.length > 0 && e.keyCode === 8 && tagInputValue.length <= 0) {
      setTagInputValue(tagList.pop());
    } else {
      return false;
    }
  };

  return (
    <Container>
      <label htmlFor="tags">
        Tags
        <div>
          <p>Add up to 5 tags to describe what your question is about</p>
        </div>
      </label>
      <TagInputContainer>
        {tagList.map((v) => (
          <Tags key={v} setTag={setTagList} tags={tagList}>
            {v}
          </Tags>
        ))}
        <input
          id="tags"
          type="text"
          placeholder="e.g. (ruby-onrails .net sql-server)"
          value={tagInputValue}
          onChange={tagInputHandler}
          onKeyDown={(e) => editTagHandler(e)}
        />
      </TagInputContainer>
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
`;

const TagInputContainer = styled.div`
  width: 100%;
  border-radius: 3px;
  border: 1px solid hsl(210, 5.5%, 43.5%);
  display: flex;
  align-items: center;
  padding: 0 9px;
  box-sizing: border-box;
  min-height: 37px;
  gap: 0.2rem;

  input {
    border: none;
    outline: none;
    margin-left: 0.3rem;
    width: 100%;
    border-radius: 3px;
    font-size: 13px;
    color: hsl(210, 4%, 95%);
    outline: none;
    background-color: hsl(0, 0%, 17.5%);
  }
`;
