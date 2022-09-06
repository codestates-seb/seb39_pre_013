/* eslint-disable jsx-a11y/anchor-is-valid */
/* eslint-disable react/destructuring-assignment */
import React from 'react';
import styled from 'styled-components';

export default function UserCard(props) {
  //   console.log(props.tags);
  return (
    <Container>
      <UserData>
        <div>
          <img src={props.profileImg} alt="profileImg" />
        </div>
        <div>
          <a href="#">{props.name}</a>
          <span>{props.location}</span>
          <span>{props.rate}</span>
        </div>
      </UserData>
      <UserTags>
        <span>tags</span>
        <span>tags</span>
        <span>tags</span>
      </UserTags>
    </Container>
  );
}

const Container = styled.article`
  display: flex;
  flex-direction: column;
  min-width: 20%;
`;

const UserData = styled.div`
  display: flex;

  div {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    img {
      width: 48px;
      height: 48px;
      border-radius: 3px;
    }

    &:nth-child(2) {
      margin-left: 9px;
    }

    a {
      font-size: 15px;
      text-decoration: none;
      color: #33a7ff;
    }

    span {
      font-size: 12px;
      color: #acb3b9;
      &:last-child {
        font-weight: bold;
      }
    }
  }
`;

const UserTags = styled.div`
  display: flex;
  justify-content: flex-start;
  font-size: 12px;
  color: #33a7ff;
  gap: 6px;
  margin-top: 4px;
  margin-left: calc(48px + 9px);
`;
