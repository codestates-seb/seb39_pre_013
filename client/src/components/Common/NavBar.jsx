import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const Bar = styled.div`
  border: 2px solid blue;
  display: flex;
  flex-direction: column;
  width: 20%;

  a {
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
  return (
    <Bar>
      <Link to="/">Questions</Link>
      <Link to="/">Tags</Link>
      <Link to="/users">Users</Link>
    </Bar>
  );
}

export default NavBar;
