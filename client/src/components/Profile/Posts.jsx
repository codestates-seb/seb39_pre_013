import React from 'react';
import styled from 'styled-components';
import ProfileTitle from './UI/ProfileTitle';

const PostsDiv = styled.div`
    margin-top: 10px;
    border: 2px solid red;
`;

const PostsContainer = styled.div`
    font-size: 16px;
    font-weight: bold;
    width:100%;
    border: 2px solid white;
    border-radius: 10px;
    box-sizing:border-box;
    padding:30px 20px;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    
    .PostsContainer-image{
        margin-bottom: 10px;
    }


    .PostsContainer-content{
        width: 70%;
        display:flex;
        flex-direction:column;
        justify-content:center;
        align-items:center;

    }


`;




function About(){
    return (
        <PostsDiv>
          <ProfileTitle>Posts</ProfileTitle>
          <PostsContainer>
            <div className="PostsContainer-image">이미지가 들어갈자리</div>
            <div className="PostsContainer-content">
                <p>Just getting started? Try answering a question!</p>
                <p>Your most helpful questions, answers and tags will appear here. Start by answering a question or selecting tags that match topics you’re interested in.</p>
            </div>
          </PostsContainer>
        </PostsDiv>
    )
}

export default About;