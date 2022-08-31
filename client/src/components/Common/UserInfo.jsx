/* eslint-disable react/destructuring-assignment */
/* eslint-disable jsx-a11y/anchor-is-valid */
import React from 'react';
import styled from 'styled-components';
import { VscCircleFilled } from 'react-icons/vsc';

export default function UserInfo(props) {
  return (
    <Container>
      <div>
        <span>asked Apr 27, 2022 at 9:23</span>
      </div>
      <ProfileBox>
        <a href="#">
          <img src={props.info.profile_image} alt="profileImg" />
        </a>
        <div>
          <a href="#">{props.info.display_name}</a>
          <ScoreBox>
            <span>{props.info.reputation}</span>
            {/* <span>
              <VscCircleFilled /> 4
            </span>
            <span>
              <VscCircleFilled />
              24
            </span>
            <span>
              <VscCircleFilled />
              27
            </span> */}
          </ScoreBox>
        </div>
      </ProfileBox>
    </Container>
  );
}

const Container = styled.article`
  padding: 2px 6px 4px 6px;
  background-color: #1b4a6f;
  border-radius: 4px;

  span {
    font-size: 13px;
    color: #acb3b9;
  }
`;

const ProfileBox = styled.div`
  display: flex;
  align-items: center;
  margin-top: 4px;

  > div {
    margin-left: 8px;
  }

  img {
    width: 32px;
    height: 32px;
    border-radius: 3px;
    vertical-align: bottom;
  }

  a {
    text-decoration: none;
    color: #33a7ff;
    font-size: 13px;
  }
`;

const ScoreBox = styled.div`
  display: flex;
  gap: 8px;

  span {
    font-size: 13px;
    color: #acb3b9;
    display: flex;
    align-items: center;

    &:nth-of-type(1) {
      font-weight: bold;
    }
  }
`;
