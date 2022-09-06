import React from 'react';
import styled from 'styled-components';

const ProfileTitleContainer = styled.div`
  font-size: 25px;
  font-weight: bold;
  padding: 5px;
`;

export default function ProfileTitle(props) {
  // eslint-disable-next-line react/destructuring-assignment
  return <ProfileTitleContainer>{props.children}</ProfileTitleContainer>;
}
