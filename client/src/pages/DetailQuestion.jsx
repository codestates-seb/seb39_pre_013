/* eslint-disable array-callback-return */
/* eslint-disable import/no-cycle */
/* eslint-disable jsx-a11y/control-has-associated-label */
/* eslint-disable jsx-a11y/label-has-associated-control */
/* eslint-disable function-paren-newline */
import axios from 'axios';
import React from 'react';
import { useQueries, useQuery } from 'react-query';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';
import Loading from '../components/Common/Loading';
import Answers from '../components/DetailQuestion/Answers';
import QuestionViewer from '../components/DetailQuestion/QuestionViewer';
import Vote from '../components/DetailQuestion/Vote';

export const dummyData = {
  title: 'Sorted function in Python dictionary',
  asked: 'today',
  modified: 'today',
  viewed: 40,
  text: `A paragraph with *emphasis* and **strong importance**.

  > A block quote with ~strikethrough~ and a URL: https://reactjs.org.
  
  A table:
  
  | a | b |
  | - | - |

  ~~~js
  console.log('It works!')
  ~~~

  ~~~jsx
  const useDialog = () => {
    const dispatch = useAppDispatch();
  
    // 리액트 컴포넌트에서 훅을 사용해서 openDialog 함수를 호출했다면
    // 썽크(thunk) 액션 생성자 함수를 통해서 액션을 디스패치하게 됩니다.
    const openDialog = async (state: DialogContents): Promise => {
      const { payload } = await dispatch(confirmationThunkActions.open(state));
  
      return payload
    };
  
    // ...
    
    return {
      openDialog,
      ...
    }
  };
~~~
  `,
  tag: ['python', 'dictionary'],
};

/**
 *
 * @Todo 답변 스타일링 수정필요, 댓글 추가 필요, 데이터 패칭 타이밍 확인 필요
 * @Params 질문, 답변에 따른 내부 데이터 변화
 */

export default function DetailQuestion() {
  const params = useParams();
  const getDetailQuestion = async () => {
    const { data } = await axios.get(
      `https://api.stackexchange.com/2.3/questions/${params.id}?page=1&pagesize=1&order=desc&sort=activity&site=stackoverflow&filter=!*MZqiH2nLUzaa-7j&key=xvUIc44g5zNOfh7F5nXJig((`,
    );

    return data;
  };

  const getAnswers = async () => {
    const { data } = await axios.get(
      `https://api.stackexchange.com/2.3/questions/${params.id}/answers?order=desc&sort=activity&site=stackoverflow&filter=!6VvPDzQn3Qm62&key=xvUIc44g5zNOfh7F5nXJig((`,
    );

    return data;
  };

  const getQuestionsComments = async () => {
    const { data } = await axios.get(
      `https://api.stackexchange.com/2.3/questions/${params.id}/comments?order=desc&sort=creation&site=stackoverflow&filter=!nKzQURB(-t&key=xvUIc44g5zNOfh7F5nXJig((`,
    );

    return data;
  };

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

<<<<<<< HEAD

=======
  console.log(`id : ${params.id} = `, result);
>>>>>>> 793f708114b2695d360ddd920911b58c03465ae6
  if (result[0].isFetching || result[1].isFetching || result[2].isFetching) {
    return <Loading />;
  }

  return (
    <Container>
      <div>
        <QuestionHeader>
          <h1>{result[0].data.items[0].title}</h1>
          <div>
            <SubText>
              <span>Asked</span>
              {dummyData.asked}
            </SubText>
            <SubText>
              <span>Modified</span>
              {dummyData.modified}
            </SubText>
            <SubText>
              <span>Viewed</span>
              {result[0].data.items[0].view_count} times
            </SubText>
          </div>
        </QuestionHeader>
        <QuestionBody>
          <Vote />
          <QuestionViewer
            mdText={result[0].data.items[0].body_markdown}
            tags={result[0].data.items[0].tags}
            owner={result[0].data.items[0].owner}
          />
        </QuestionBody>
      </div>
      <AnswerContainer>
        {result[1].data.items.length !== 0 && (
          <Answers answerData={result[1].data.items} />
        )}
      </AnswerContainer>
    </Container>
  );
}

// eslint-disable-next-line no-lone-blocks
{
  /* <Answers answerData={result[1].data.items} /> */
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
