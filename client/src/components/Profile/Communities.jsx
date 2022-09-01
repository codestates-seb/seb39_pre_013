import React from 'react';
import styled from 'styled-components';
import ProfileTitle from './UI/ProfileTitle';

const CommunitiesDiv = styled.div`
    margin-top: 10px;
`;

const CommunitiesContainer = styled.div`
    font-size: 25px;
    font-weight: bold;
    width:100%;
    border: 2px solid white;
    border-radius: 3%;
    box-sizing:border-box;
`;




function Communities(){
    return (
        <CommunitiesDiv>
          <ProfileTitle>Communities</ProfileTitle>
          <CommunitiesContainer>
                StackOverFlow
          </CommunitiesContainer>
        </CommunitiesDiv>
    )
}

export default Communities;