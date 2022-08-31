import React from 'react';
import ClipLoader from 'react-spinners/ClipLoader';
import styled from 'styled-components';

export default function Loading() {
  return (
    <Container>
      <ClipLoader size={300} />
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
`;
