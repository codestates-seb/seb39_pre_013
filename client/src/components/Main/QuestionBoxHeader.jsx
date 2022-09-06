/* eslint-disable import/no-cycle */
import React from 'react';
import styled from 'styled-components';
import { Link, useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { useQuery } from 'react-query';
import Button from '../UI/Button';
import { logoutActions } from '../../store/reducers';
import { persistor } from '../..';
import Loading from '../Common/Loading';
import { authUser, removeToken } from '../../utils/auth';

const StyledHeader = styled.div`
  height: 140px;
  width: 100%;
  display: flex;
  flex-direction: column;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 20px;
  box-sizing: border-box;
  border-bottom: 1px solid hsl(210, 4%, 26%);

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
      border-radius: 3px;
      border: 1px solid hsl(210, 6.5%, 52%);
      font-size: 13px;
      color: #acb3b9;
      button {
        padding: 8px 8px;
        border: none;
        background-color: transparent;
        color: #acb3b9;
        cursor: pointer;
        &:not(:last-child) {
          border-right: 1px solid hsl(210, 6.5%, 52%);
          /* border-left: 1px solid hsl(210, 6.5%, 52%); */
        }
      }
    }
  }
`;

function QuestionBoxHeader() {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const errorHandler = () => {
    console.log('inner error');
    dispatch(logoutActions());
    removeToken();
    persistor.pause();
    persistor.flush().then(() => persistor.purge());
    navigate('/login');
  };

  const { data, isFetching, refetch, isError } = useQuery(['auth'], authUser, {
    refetchOnWindowFocus: false,
    enabled: false,
    refetchOnMount: false,
  });

  console.log('inner aq :', data);

  const questionBtnHandler = async () => {
    const refetchStatus = await refetch();

    if (refetchStatus.status === 'error') {
      errorHandler();
    } else {
      navigate('/askquestion');
    }
  };

  return (
    <StyledHeader>
      <div className="questionsHeader__top">
        <span>Top Questions</span>
        <Button onClick={questionBtnHandler}>Ask Question</Button>
      </div>
      <div className="questionsHeader__bottom">
        <div className="sortBox">
          <button type="button">Interesting</button>
          <button type="button">Bounted</button>
          <button type="button">Hot</button>
          <button type="button">Week</button>
          <button type="button">Month</button>
        </div>
      </div>
    </StyledHeader>
  );
}

export default QuestionBoxHeader;
