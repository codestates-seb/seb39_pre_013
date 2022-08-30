import React from 'react';
import styled from 'styled-components';
// eslint-disable-next-line import/no-cycle
import { dummyData } from '../../pages/DetailQuestion';
import Comments from './Comments';
import Markdown from '../AskQuestion/Markdown';
import QuestionMenu from './QuestionMenu';
import TagUI from '../UI/TagUI';

/**
 *
 * @todo : 댓글 기능 추가, Styled Component 컴포넌트 선택자 찾아보기, bookmark 추가
 */
export default function QuestionViewer() {
  return (
    <Container>
      <Markdown text={dummyData.text} />
      <TagBox>
        {dummyData.tag.map((v) => (
          <TagUI key={v}>{v}</TagUI>
        ))}
      </TagBox>
      <QuestionMenu />
      <Comments />
    </Container>
  );
}

const Container = styled.article`
  width: 100%;

  ${Markdown} {
    margin-bottom: 20px;
  }
`;

const TagBox = styled.div`
  margin-top: 32px;
  display: flex;
  justify-content: flex-start;
  gap: 10px;
  margin-bottom: 20px;
`;
