/* eslint-disable react/destructuring-assignment */
import React from 'react';
import styled from 'styled-components';
import Comments from './Comments';
import Markdown from '../AskQuestion/Markdown';
import QuestionMenu from './QuestionMenu';
import TagUI from '../UI/TagUI';

/**
 *
 * @todo : 댓글 기능 추가, Styled Component 컴포넌트 선택자 찾아보기, bookmark 추가
 */
export default function QuestionViewer(props) {
  return (
    <Container>
      {/* <Markdown text={dummyData.text} /> */}
      <Markdown text={props.mdText} />
      <TagBox>
        {props.tags &&
          props.tags.map((v) => <TagUI key={v.id}>{v.name}</TagUI>)}
      </TagBox>
      <QuestionMenu owner={props.owner} />
      {/* <Comments /> */}
    </Container>
  );
}

const Container = styled.article`
  width: 100%;
`;

const TagBox = styled.div`
  margin-top: 32px;
  display: flex;
  justify-content: flex-start;
  gap: 10px;
  margin-bottom: 20px;
`;
