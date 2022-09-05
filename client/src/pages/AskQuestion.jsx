/* eslint-disable import/no-cycle */
/* eslint-disable import/no-unresolved */
/* eslint-disable function-paren-newline */
import axios from 'axios';
import React, { useEffect } from 'react';
import { useQuery } from 'react-query';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import Editor from '../components/AskQuestion/Editor';
import InputTags from '../components/AskQuestion/InputTags';
import InputTitle from '../components/AskQuestion/InputTitle';
import Loading from '../components/Common/Loading';
import Button from '../components/UI/Button';
import { logoutActions } from '../store/reducers';
import { authUser } from '../utils/auth';

export default function AskQuestion() {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const { data, isFetching } = useQuery('authUser', authUser, {
    refetchOnWindowFocus: false,
  });

  console.log('inner aq :', data);

  if (!data) {
    dispatch(logoutActions());
    navigate('/login');
  }

  if (isFetching) {
    return <Loading />;
  }

  return (
    <Container>
      <div className="title-box">
        <h2>Ask a public question</h2>
      </div>
      <FormContainer>
        <InputTitle />
        <Editor />
        <InputTags />
      </FormContainer>
      <div className="btn-box">
        <Button>Review your question</Button>
      </div>
    </Container>
  );
}

const Container = styled.article`
  width: 100%;
  .title-box {
    height: 130px;
    background-image: url('https://cdn.sstatic.net/Img/ask/background.svg?v=2e9a8205b368');
    background-repeat: no-repeat;
    background-position: right bottom !important;
    display: flex;
    align-items: center;
    justify-content: flex-start;
  }

  .btn-box {
    margin-top: 20px;
    display: flex;
    gap: 4px;
  }
`;

const FormContainer = styled.form`
  background-color: #2d2d2d;
  padding: 1rem;
  border-radius: 3px;
  border: 1px solid hsl(210, 4.5%, 30.5%);
  display: flex;
  flex-direction: column;
  gap: 10px;
`;
