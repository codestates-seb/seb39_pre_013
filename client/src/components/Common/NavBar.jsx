import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const Bar = styled.nav`
  display: flex;
  flex-direction: column;
  width: 165px;
  position: relative;
  border-right: 1px solid hsl(210, 4.5%, 30.5%);

  a {
    color: white;
    display: flex;
    justify-content: flex-start;
    font-size: 13px;
    margin: 0.6rem 0;
    cursor: pointer;
    text-decoration: none;
    padding: 10px 6px;
  }
`;

const NavMenu = styled.div`
  padding-top: 30px;
  position: sticky;
  top: 50px;
`;

const NavLink = styled(Link)`
  border-right: 3px solid #ffa500;
  background-color: transparent;
  background-color: ${(props) => props.active && '#3d3d3d'};
`;

function NavBar() {
  return (
    <Bar>
<<<<<<< HEAD
      <Link to="/">Questions</Link>
      <Link to="/">Tags</Link>
      <Link to="/users">Users</Link>
=======
      <NavMenu>
        <NavLink to="/" active>
          Questions
        </NavLink>
        <Link to="/">Tags</Link>
        <Link to="/users">Users</Link>
      </NavMenu>
>>>>>>> 65a26914e544a3fc0fd55007397cfddbcfe243bf
    </Bar>
  );
}

export default NavBar;
