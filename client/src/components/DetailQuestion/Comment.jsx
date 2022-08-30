/* eslint-disable jsx-a11y/anchor-is-valid */
/* eslint-disable react/destructuring-assignment */
import React, { useState } from 'react';
import styled from 'styled-components';
import { IoPencilSharp } from 'react-icons/io5';
import Markdown from './Markdown';
import Button from './UI/Button';

export default function Comment(props) {
  const [isEdit, setIsEdit] = useState(false);
  const [editText, setEditText] = useState(props.comment);

  const editCommentHandler = () => {
    setIsEdit(true);
  };

  const editChangeHandler = (e) => {
    setEditText(e.target.value);
  };

  const editPostHandler = () => {
    setIsEdit(false);
  };

  return (
    <Container>
      {isEdit ? (
        <EditArea>
          <textarea value={editText} onChange={editChangeHandler} />
          <Button onClick={editPostHandler}>Edit</Button>
        </EditArea>
      ) : (
        <>
          <span>1</span>
          <div>
            <Markdown text={props.comment} /> - <a href="#">bloxxom</a>
            <span>May 22, 2022 at 13:01</span>
            <button type="button" onClick={editCommentHandler}>
              <IoPencilSharp viewBox="0 0 512 410" />
            </button>
          </div>
        </>
      )}
    </Container>
  );
}

const Container = styled.div`
  height: 100%;
  border-bottom: 1px solid hsl(0, 0%, 24%);
  display: flex;
  font-size: 13px;
  padding: 8px 0;

  button {
    border: none;
    background-color: transparent;
    cursor: pointer;

    path {
      fill: #959ca3;
    }
  }

  div {
    margin: 0;
    width: 100%;
  }

  span {
    margin-right: 4px;
    color: #959ca3;
    &:nth-child(1) {
      margin-right: 12px;
      color: #fff;
    }
  }

  a {
    color: #33a7ff;
    margin-right: 4px;
  }

  textarea {
    width: 100%;
    min-height: 70px;
    overflow-y: scroll;
  }
`;

const EditArea = styled.div`
  display: flex;
  align-items: flex-start;
  gap: 8px;

  button {
    background-color: #0964aa;
  }
`;
