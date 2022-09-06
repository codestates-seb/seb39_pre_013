import React from 'react';
import ScaleLoader from 'react-spinners/ScaleLoader';
import styled from 'styled-components';

export default function Loading() {
  return (
    <Container>
      <ScaleLoader color="#fff" />
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
