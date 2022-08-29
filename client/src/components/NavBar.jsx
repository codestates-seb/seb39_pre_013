import React from 'react';
import styled from 'styled-components';

const Bar = styled.div`
    border: 2px solid blue;
    display:flex;
    flex-direction: column;
    width: 20%;


    div{
        color:white;
        width: 100%;
        display:flex;
        justify-content: center;
        font-size: 1.5rem;
        margin: .6rem 0;
        cursor: pointer;
    }
`;

function NavBar() {
  return (
    <Bar>
      <div>Questions</div>
      <div>Tags</div>
      <div>Users</div>
    </Bar>
  );
}

export default NavBar;
