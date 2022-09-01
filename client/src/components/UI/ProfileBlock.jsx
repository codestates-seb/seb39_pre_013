import React from 'react';
import styled from 'styled-components';

const ProfileBlockContainer = styled.div`
  font-size: 25px;
  font-weight: bold;
  width: 100%;
  box-sizing: border-box;
`;

export default function ProfileBlock(props) {
  // eslint-disable-next-line react/destructuring-assignment
  return <ProfileBlockContainer>{props.children}</ProfileBlockContainer>;
}
