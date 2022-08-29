import React from 'react';
import styled from 'styled-components';

const StyledTagButton = styled.span`
background-color: #046fbb;
padding: 2px 2px;
cursor: pointer;
display:flex;
justify-content:center;
align-items: center;
margin-right: 10px;
font-size: 1rem;
`;

function StyledTag(tagName) {
  return (
    <StyledTag>{tagName}</StyledTag>
  );
}

export default StyledTag;
