import React from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const StyledHeader = styled.div`
  height: 140px;
  width: 100%;
  border: 2px solid turquoise;
  display: flex;
  flex-direction: column;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 20px;
  box-sizing: border-box;

  .questionsHeader__top {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
    span {
      font-size: 25px;
      font-weight: bold;
    }

    div {
      padding: 10px 10px;
      border-radius: 3%;
      border: 2px solid white;
      cursor: pointer;
    }
  }

  .questionsHeader__bottom {
    display: flex;
    justify-content: end;
    align-items: center;
    margin-top: 10px;
    padding: 5px 0;

    .sortBox {
      display: flex;
      border-radius: 2px;
      font-size: 22px;

      div {
        border: 2px solid turquoise;
        padding: 5px 5px;
      }
    }
  }
`;

function QuestionBoxHeader() {
  const navigate = useNavigate();

  const answerQuestionsHandler = () => {
    navigate('/askquestion');
  };
  return (
    <StyledHeader>
      <div className="questionsHeader__top">
        <span>Top Questions</span>
        <button type="button" onClick={answerQuestionsHandler}>
          Ask Question
        </button>
      </div>
      <div className="questionsHeader__bottom">
        <div className="sortBox">
          <div>Interesting</div>
          <div>Bounted</div>
          <div>Hot</div>
          <div>Week</div>
          <div>Month</div>
        </div>
      </div>
    </StyledHeader>
  );
}

export default QuestionBoxHeader;
