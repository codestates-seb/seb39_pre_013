import React from 'react';
import styled from 'styled-components';
import Comment from './Comment';

export const dummyText =
  'Beware software rot—upgrading dependencies might break your app. You can list the exact version of all installed packages with pip freeze (like bundle install or npm shrinkwrap). Best to save a copy of that before tinkering.';

/**
 *
 * @Comment - 데이터 양에 따라 map으로 반복 예정
 */
export default function Comments() {
  return (
    <Container>
      <Comment comment={dummyText} />
      <Comment comment={dummyText} />
      <Comment comment={dummyText} />
    </Container>
  );
}

const Container = styled.article`
  border-top: 1px solid hsl(0, 0%, 24%);
  margin-top: 1rem;
`;
