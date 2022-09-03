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
  padding: 24px;

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
    const { data } = await axios.get(
      'https://api.stackexchange.com/2.3/questions?page=1&pagesize=10&order=desc&sort=activity&site=stackoverflow&filter=!9Tk7U8l6-&key=xvUIc44g5zNOfh7F5nXJig((',
    );

    return data;
  };

  const { status, data, error, isFetching } = useQuery(
    'getQuestions',
    getQuestions,
    { refetchOnWindowFocus: false },
  );

  if (isFetching) {
    return <Loading />;
  }

  return (
    <StyledMain>
      <div className="mainContentsBox">
        <div className="questionsBox">
          <QuestionBoxHeader />
          {data.items.map((v) => (
            <QuestionBlock
              key={v.question_id}
              id={v.question_id}
              answers={v.answer_count}
              title={v.title}
              tags={v.tags}
              createDate={v.creation_date}
              views={v.view_count}
              voteCount={v.score}
            />
          ))}
        </div>
      </div>
    </StyledMain>
  );
}

export default QuestionsSection;
