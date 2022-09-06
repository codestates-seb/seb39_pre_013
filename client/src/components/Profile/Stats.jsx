import React from 'react';
import styled from 'styled-components';
import ProfileTitle from '../UI/ProfileTitle';

const StatsContainer = styled.div`
  font-size: 25px;
  font-weight: bold;
  width: 100%;
  border: 2px solid white;
  border-radius: 3%;
  box-sizing: border-box;
  > div {
    display: flex;
    div {
      width: 100%;
      height: 4rem;
      border: 2px solid red;
      display: flex;
      flex-direction: column;
    }
  }
`;

function Stats() {
  return (
    <>
      <ProfileTitle>Stats</ProfileTitle>
      <StatsContainer>
        <div className="firstFloor">
          <div>
            <span>0</span>
            <span>reputation</span>
          </div>
          <div>
            <span>0</span>
            <span>reached</span>
          </div>
        </div>
        <div className="secontFloor">
          <div>
            <span>0</span>
            <span>answers</span>
          </div>
          <div>
            <span>0</span>
            <span>questions</span>
          </div>
        </div>
      </StatsContainer>
    </>
  );
}

export default Stats;
