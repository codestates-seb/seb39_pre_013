/* eslint-disable array-callback-return */
/* eslint-disable import/no-cycle */
/* eslint-disable jsx-a11y/control-has-associated-label */
/* eslint-disable jsx-a11y/label-has-associated-control */
/* eslint-disable function-paren-newline */
import axios from 'axios';
import React, { useState } from 'react';
import { useMutation, useQuery, useQueryClient } from 'react-query';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';
import ClipLoader from 'react-spinners/ClipLoader';
import Editor from '../components/AskQuestion/Editor';
import Loading from '../components/Common/Loading';
import Answers from '../components/DetailQuestion/Answers';
import Comments from '../components/DetailQuestion/Comments';
import QuestionViewer from '../components/DetailQuestion/QuestionViewer';
import Vote from '../components/DetailQuestion/Vote';
import Button from '../components/UI/Button';

/**
 *
 * @Todo 답변 스타일링 수정필요, 댓글 추가 필요, 데이터 패칭 타이밍 확인 필요
 * @Params 질문, 답변에 따른 내부 데이터 변화
 */

export default function DetailQuestion() {
  const [editorValue, setEditorValue] = useState(undefined);
  const params = useParams();
  const queryClient = useQueryClient();
  const getDetailQuestion = async () => {
    const { data } = await axios.get(`/api/v1/questions/${params.id}`, {
      withCredentials: true,
    });

    return data;
  };

  const { data, isFetching } = useQuery(
    'getDetailQuestion',
    getDetailQuestion,
    { refetchOnWindowFocus: false },
  );

  const postAnswer = useMutation((payload) =>
    axios.post('/api/v1/answers', payload, { withCredentials: true }),
  );

  const AddAnswerHandler = () => {
    postAnswer.mutate({
      questionId: params.id,
      userId: 1,
      content: editorValue,
    });
    setEditorValue('');
  };

<<<<<<< HEAD
  const result = useQueries([
    {
      queryKey: ['getDetaikQuestion'],
      queryFn: () => getDetailQuestion(),
      refetchOnWindowFocus: false,
    },
    {
      queryKey: ['getAnswers'],
      queryFn: () => getAnswers(),
      refetchOnWindowFocus: false,
    },
    {
      queryKey: ['getQuestionsComments'],
      queryFn: () => getQuestionsComments(),
      refetchOnWindowFocus: false,
    },
  ]);

  console.log(`id : ${params.id} = `, result[2]);
  if (result[0].isFetching || result[1].isFetching || result[2].isFetching) {
=======
  console.log(`id : ${params.id} = `, data);
  if (isFetching) {
>>>>>>> 0c79900be3135f7e142b4a8039711dfd71931f0e
    return <Loading />;
  }

  return (
    <Container>
      <div>
        <QuestionHeader>
          <h1>{data.data.title}</h1>
          <div>
            <SubText>
              <span>Asked</span>
              today
            </SubText>
            <SubText>
              <span>Modified</span>
              {data.data.modifiedAt}
            </SubText>
            <SubText>
              <span>Viewed</span>
              {data.data.view} times
            </SubText>
          </div>
        </QuestionHeader>
        <QuestionBody>
          <Vote />
          <QuestionViewer
            mdText={data.data.content}
            tags={data.data.questionTags}
            owner={data.data.user}
          />
        </QuestionBody>
        <Comments commnetData={result[2].data.items} />
      </div>
      <AnswerContainer>
<<<<<<< HEAD
        {result[1].data.items.length !== 0 && (
          <Answers answerData={result[1].data} />
=======
        {data.data.answers.length !== 0 && (
          <Answers answerData={data.data.answers} />
>>>>>>> 0c79900be3135f7e142b4a8039711dfd71931f0e
        )}
      </AnswerContainer>
      <AddAnswers>
        <span>Your Answer</span>
        <Editor setEditorValue={setEditorValue} />
      </AddAnswers>
      <Button onClick={AddAnswerHandler}>
        {postAnswer.isLoading ? (
          <>
            <ClipLoader size={14} color="#fff" /> Post...
          </>
        ) : (
          'Post Your Answer'
        )}
      </Button>
    </Container>
  );
}

const Container = styled.article`
  padding: 24px;
  background-color: hsl(0, 0%, 17.5%);
`;

const QuestionHeader = styled.div`
  border-bottom: 1px solid hsl(210, 4%, 26%);
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding-bottom: 1rem;

  h1 {
    font-size: 2rem;
    margin-bottom: 0.8rem;
  }

  > div {
    display: flex;
    flex-direction: row;
    gap: 1rem;
  }
`;

const SubText = styled.div`
  font-size: 13px;
  span {
    color: hsl(210, 8%, 70%);
    margin-right: 5px;
  }
`;

const QuestionBody = styled.section`
  display: flex;
`;

const AnswerContainer = styled.div``;

const AddAnswers = styled.div`
  margin-top: 20px;
  span {
    font-size: 18px;
    display: block;
    margin-bottom: 20px;
  }
`;
