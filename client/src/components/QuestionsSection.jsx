import React from 'react';
import styled from 'styled-components';
import NavBar from './NavBar';
import QuestionBoxHeader from './QuestionBoxHeader';
import QuestionBlock from './QuestionBlock';

const StyledMain = styled.div`
    background-color: #2d2d2d;
    display:flex;
    justify-content: center;
    border: 5px solid white;
    box-sizing: border-box;
    width: 100%;
    height: 300vh;

    .mainContentsBox{
        width: 70%;
        border: 2px solid red;
        display: flex;
    }

    .questionsBox{
      width:80%;
    }


`;

const StyledNavdiv = styled.div`
    color:white;
    width: 100%;
    display:flex;
    justify-content: center;
    font-size: 1.5rem;
    margin: .6rem 0;
    cursor: pointer;

    
`;

function QuestionsSection() {
  return (
    <StyledMain>
      <div className="mainContentsBox">
        <NavBar />
        <div className="questionsBox">
          <QuestionBoxHeader />
          <QuestionBlock />
          <QuestionBlock />
          <QuestionBlock />
        </div>
      </div>

    </StyledMain>
  );
}

export default QuestionsSection;
