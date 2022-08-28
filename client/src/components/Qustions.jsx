import React from 'react';
import styled from 'styled-components';

const StyledMain = styled.div`
    background-color: #2d2d2d;
    display:flex;
    justify-content: center;
    border: 2px solid white;
    height: 100vh;
    box-sizing: border-box;


    .questionsContents{
        width: 70%;
        border: 2px solid red;
        display: flex;
    }

    .questionsContents__navBar{
        padding-top: 1rem;
        width: 20%;
        border: 2px solid blue;
        display:flex;
        flex-direction: column;
    }

    .questionsBox{
      border: 2px solid white;
      width: 100%;
      padding-left: 20px;
      padding-right: 20px;
      padding-top: 20px;
    }
    .questionsHeader{
      width: 100%;
      border: 2px solid turquoise;
      
    }

    .questionsHeader__Top{
      display:flex;
      justify-content: space-between;
      align-items: center;
      border: 2px solid white;
      span{
        font-size: 25px;
        font-weight: bold;
      }

      div{
        padding: 10px 10px;
        background-color: turquoise;
        border-radius: 3%;
        cursor: pointer;
      }  
    }

    .questionsHeader__Bottom{
      display: flex;
      justify-content: end;
      align-items: center;
      margin-top: 10px;
      border: 2px solid red;
      padding: 5px 0;

      .sortBox{
        display: flex;
        border: 2px solid white;
        border-radius: 2px;

        div{
          border: 2px solid turquoise;
        }
      }
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

const StyledTagButton = styled.span`
    background-color: #046fbb;
    padding: 2px 2px;
    cursor: pointer;
    display:flex;
    justify-content:center;
    align-items: center;
    margin-right: 10px;
    font-size: 1rem;
`;

const StyledQuestionBox = styled.div`
  height:120px;
  border: 2px solid white;
  display:flex;
  
  .questionsList__left{
    width:12%;
    display:flex;
    flex-direction: column;
    align-items: flex-end;
    justify-content: center;
    padding-right: 30px;
    
    div{
      margin: 5px 0;
    }
  }

  .questionsList__right{
    display:flex;
    flex-direction: column;
    justify-content: center;
    
    div{
      margin: 5px 0;
    }

    .tagBox{
      display:flex;
    }

  }
`;

function Questions() {
  return (
    <StyledMain>

      <div className="questionsContents">
        <div className="questionsContents__navBar">
          <StyledNavdiv>Questions</StyledNavdiv>
          <StyledNavdiv>Tags</StyledNavdiv>
          <StyledNavdiv>Users</StyledNavdiv>
        </div>
        <div className="questionsBox">
          <div className="questionsHeader">
            <div className="questionsHeader__Top">
              <span>Top Questions</span>
              <div>Ask Question</div>
            </div>
            <div className="questionsHeader__Bottom">
              <div className="sortBox">
                <div>Interesting</div>
                <div>Bounted</div>
                <div>Hot</div>
                <div>Week</div>
                <div>Month</div>
              </div>
            </div>
          </div>
          <div className="questionsList">
            <StyledQuestionBox>
              <div className="questionsList__left">
                <div>votes</div>
                <div>answers</div>
                <div>views</div>
              </div>
              <div className="questionsList__right">
                <div>제목</div>
                <div className="tagBox">
                  <StyledTagButton>Tag1</StyledTagButton>
                  <StyledTagButton>Tag2</StyledTagButton>
                </div>
                <div>유저정보/작성시간/메타정보</div>
              </div>
            </StyledQuestionBox>
            <StyledQuestionBox>
              <div className="questionsList__left">
                <div>votes</div>
                <div>answers</div>
                <div>views</div>
              </div>
              <div className="questionsList__right">
                <div>제목</div>
                <div className="tagBox">
                  <StyledTagButton>Tag1</StyledTagButton>
                  <StyledTagButton>Tag2</StyledTagButton>
                </div>
                <div>유저정보/작성시간/메타정보</div>
              </div>
            </StyledQuestionBox>
          </div>
        </div>
      </div>
    </StyledMain>
  );
}

export default Questions;
