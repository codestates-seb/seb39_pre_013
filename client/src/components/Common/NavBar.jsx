import React from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
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

const NavLinkStyle = styled(NavLink)`
  background-color: transparent;

  &.active {
    border-right: 3px solid #ffa500;
    background-color: #3d3d3d;
  }
`;

function NavBar() {
  return (
    <Bar>
      <NavMenu>
        <NavLinkStyle to="/">Questions</NavLinkStyle>
        <NavLinkStyle to="/ae">Tags</NavLinkStyle>
        <NavLinkStyle to="/users">Users</NavLinkStyle>
      </NavMenu>
    </Bar>
  );
}

export default NavBar;
