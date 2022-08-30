import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const Bar = styled.div`
  border: 2px solid blue;
  display: flex;
  flex-direction: column;
  width: 20%;

  div {
    color: white;
    width: 100%;
    display: flex;
    justify-content: center;
    font-size: 1.5rem;
    margin: 0.6rem 0;
    cursor: pointer;
  }
`;

function NavBar() {
  const navigate = useNavigate();
  return (
    <Bar>
      <button type="button" onClick={() => navigate('/')}>
        Questions
      </button>
      <div>Tags</div>
      <div>Users</div>
    </Bar>
  );
}

export default NavBar;
