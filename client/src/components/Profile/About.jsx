import React from 'react';
import styled from 'styled-components';
import ProfileTitle from '../UI/ProfileTitle';

const AboutDiv = styled.div`
  margin-top: 10px;
  border: 2px solid red;
`;

const AboutContainer = styled.div`
  font-size: 16px;
  font-weight: bold;
  width: 100%;
  border: 2px solid white;
  border-radius: 10px;
  box-sizing: border-box;
  padding: 30px 20px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function About() {
  return (
    <AboutDiv>
      <ProfileTitle>About</ProfileTitle>
      <AboutContainer>
        Your about me section is currently blank. Would you like to add one?
        Edit profile
      </AboutContainer>
    </AboutDiv>
  );
}

export default About;
