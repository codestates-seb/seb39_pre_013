import React from 'react';
import styled from 'styled-components';
// eslint-disable-next-line import/no-cycle
import QuestionViewer from '../../components/QuestionViewer';
import Vote from '../../components/Vote';

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

export default function DetailQuestion() {
  return (
    <Container>
      <QuestionHeader>
        <h1>{dummyData.title}</h1>
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
            {dummyData.viewed} times
          </SubText>
        </div>
      </QuestionHeader>
      <QuestionBody>
        <Vote />
        <QuestionViewer />
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
