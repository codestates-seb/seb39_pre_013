/* eslint-disable import/no-cycle */
/* eslint-disable function-paren-newline */
import React from 'react';
import styled from 'styled-components';
import axios from 'axios';
import { useQuery } from 'react-query';
import QuestionBoxHeader from '../components/Main/QuestionBoxHeader';
import QuestionBlock from '../components/Main/QuestionBlock';
import Loading from '../components/Common/Loading';

const StyledMain = styled.div`
  background-color: #2d2d2d;
  display: flex;
  justify-content: center;
  box-sizing: border-box;
  width: 100%;
  height: 100%;

  .mainContentsBox {
    width: 100%;
    display: flex;
  }

  .questionsBox {
    width: 80%;
  }
`;

const StyledNavdiv = styled.div`
  color: white;
  width: 100%;
  display: flex;
  justify-content: center;
  font-size: 1.5rem;
  margin: 0.6rem 0;
  cursor: pointer;
`;
function QuestionsSection() {
  const getQuestions = async () => {
    const { data } = await axios.get('/api/v1/questions?page=1&size=10', {
      withCredentials: true,
    });

    return data;
  };

  const { status, data, error, isFetching } = useQuery(
    'getQuestions',
    getQuestions,
    { refetchOnWindowFocus: false },
  );

  console.log(data);
  if (isFetching) {
    return <Loading />;
  }
  return (
    <StyledMain>
      <div className="mainContentsBox">
        <div className="questionsBox">
          <QuestionBoxHeader />
          {data.data.map((v) => (
            <QuestionBlock
              key={v.id}
              id={v.id}
              answers={v.answers}
              title={v.title}
              tags={v.questionTags}
              createDate={v.creation_date}
              views={v.view}
              voteCount={v.vote}
              createdAt={v.createdAt}
              modifiedAt={v.modifiedAt}
              user={v.user}
            />
          ))}
        </div>
      </div>
    </StyledMain>
  );
}

export default QuestionsSection;
