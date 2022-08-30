import React from 'react';
import styled from 'styled-components';

const QuestionBlockDiv = styled.div`
  border: 2px solid white;
  width: 100%;
  height: 150px;
  box-sizing: border-box;
  display: flex;

  .questionsList__left {
    width: 130px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    border: 2px solid white;

    div {
      margin: 5px 0;
    }
  }

  .questionsList__right {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding-left: 20px;

    div {
      margin: 5px 0;
    }

    .tagBox {
      display: flex;
      div {
        margin-right: 12px;
        border: 2px solid white;
      }
    }
  }
`;

function QuestionBlock() {
  return (
    <QuestionBlockDiv>
      <div className="questionsList__left">
        <div>votes</div>
        <div>answers</div>
        <div>views</div>
      </div>
      <div className="questionsList__right">
        <div>제목</div>
        <div className="tagBox">
          <div>tag1</div>
          <div>tag2</div>
        </div>
        <div>유저정보/작성시간/메타정보</div>
      </div>
    </QuestionBlockDiv>
  );
}

export default QuestionBlock;
