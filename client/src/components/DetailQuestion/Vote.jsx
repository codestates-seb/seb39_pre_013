import React from 'react';
import styled from 'styled-components';
import { MdOutlineArrowDropUp, MdOutlineArrowDropDown } from 'react-icons/md';

export default function Vote() {
  return (
    <Container>
      <ButtonContainer type="button">
        <MdOutlineArrowDropUp
          color="#696f75"
          size={54}
          style={{ display: 'block' }}
        />
      </ButtonContainer>
      <div>0</div>
      <ButtonContainer type="button">
        <MdOutlineArrowDropDown
          color="#696f75"
          size={54}
          style={{ display: 'block' }}
        />
      </ButtonContainer>
    </Container>
  );
}

const Container = styled.div`
  width: auto;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  margin-right: 1rem;

  div {
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.6rem;
  }
`;

const ButtonContainer = styled.button`
  width: fit-content;
  cursor: pointer;
  border: none;
  background-color: transparent;
`;
