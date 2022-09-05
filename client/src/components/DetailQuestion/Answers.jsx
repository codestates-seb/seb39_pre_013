/* eslint-disable react/destructuring-assignment */
/* eslint-disable import/no-cycle */
/* eslint-disable jsx-a11y/label-has-associated-control */
import React from 'react';
import styled from 'styled-components';

import QuestionViewer from './QuestionViewer';
import Vote from './Vote';

export default function AnswerHeader(props) {
  return (
    <Container>
      <AnswerHead>
        <span>Answer</span>
        <div>
          <label htmlFor="sort">Sorted by:</label>
          <select name="sorted answer" id="sort">
            <option value="score">Highest score (default)</option>
            <option value="tranding">Trending (recent votes count more)</option>
            <option value="modified">Date modified (newest first)</option>
            <option value="created">Date created (oldest first)</option>
          </select>
        </div>
      </AnswerHead>
      {props.answerData.items.map((v) => (
        <AnswerBody key={v.answer_id}>
          <Vote />
          <QuestionViewer mdText={v.body_markdown} owner={v.owner} />
        </AnswerBody>
      ))}
    </Container>
  );
}

const Container = styled.div`
  padding-top: 10px;
  width: 100%;
`;

const AnswerHead = styled.div`
  display: flex;
  justify-content: space-between;

  span {
    font-size: 19px;
  }

  label {
    font-size: 12px;
    margin-right: 6px;
  }

  select {
    padding: 0.5rem 0.9rem 0.5rem 0.7rem;
    background-color: transparent;
    font-size: 13px;
    color: #ffffff;
    border-radius: 3px;
    border-color: hsl(210, 5%, 44%);
    outline: 0;
  }
`;

const AnswerBody = styled.div`
  display: flex;
`;
