/* eslint-disable function-paren-newline */
import axios from 'axios';
import React from 'react';
import { useQuery } from 'react-query';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';
import Loading from '../components/Common/Loading';
// eslint-disable-next-line import/no-cycle
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
 * @Todo 내부 QuestionHeader 컴포넌트 분리
 * @Params 질문, 답변에 따른 내부 데이터 변화
 */

export default function DetailQuestion() {
  const params = useParams();
  const getDetailQuestion = async () => {
    const { data } = await axios.get(
      `https://api.stackexchange.com/2.3/questions/${params.id}?page=1&pagesize=1&order=desc&sort=activity&site=stackoverflow&filter=!*MZqiH2Uet7YhfzI`,
    );

    return data;
  };

  const { isLoading, data, error, isFetching } = useQuery(
    'getDetailQuestion',
    getDetailQuestion,
    { refetchOnWindowFocus: false },
  );

  if (isFetching) {
    return <Loading />;
  }

  return (
    <Container>
      <QuestionHeader>
        <h1>{data.items[0].title}</h1>
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
            {data.items[0].view_count} times
          </SubText>
        </div>
      </QuestionHeader>
      <QuestionBody>
        <Vote />
        <QuestionViewer
          mdText={data.items[0].body_markdown}
          tags={data.items[0].tags}
          owner={data.items[0].owner}
        />
      </QuestionBody>
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
