/* eslint-disable react/destructuring-assignment */
import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import Moment from 'react-moment';
import TagUI from '../UI/TagUI';

const QuestionBlockDiv = styled.div`
  width: 100%;
  padding: 1rem;
  box-sizing: border-box;
  display: flex;
  border-bottom: 1px solid hsl(210, 4%, 26%);

  .questionsList__left {
    width: 130px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    div {
      margin: 5px 0;
      font-size: 13px;
    }
  }

  .questionsList__right {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding-left: 20px;
    width: 100%;
    gap: 8px;
    .tagBox {
      display: flex;
      gap: 10px;
    }

    a {
      text-decoration: none;
      color: #33a7ff;
    }
  }
`;

const OwnerInfo = styled.div`
  width: 100%;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  gap: 6px;
  font-size: 12px;
`;

function QuestionBlock(props) {
  return (
    <QuestionBlockDiv>
      <div className="questionsList__left">
        <div>{props.voteCount || 0} votes</div>
        <div>{props.answers.length || 0} answers</div>
        <div>{props.views || 0} views</div>
      </div>
      <div className="questionsList__right">
        <Link to={`question/${props.id}`}>{props.title}</Link>
        <div className="tagBox">
          {props.tags.map((v) => (
            <TagUI key={v.id}>{v.name}</TagUI>
          ))}
        </div>
        <OwnerInfo>
          <div>{props.user.nickname}</div>
          <div>{props.user.reputation}</div>
          {props.modifiedAt ? (
            <>
              modified
              <Moment toNow>{props.modifiedAt}</Moment>
            </>
          ) : (
            <>
              asked
              <Moment toNow>{props.createdAt}</Moment>
            </>
          )}
        </OwnerInfo>
      </div>
    </QuestionBlockDiv>
  );
}

export default QuestionBlock;
