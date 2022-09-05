import React, { useEffect, useState } from 'react';
import styled, { css } from 'styled-components';
import { BsStackOverflow } from 'react-icons/bs';
import { Link } from 'react-router-dom';
import { IoSearchSharp } from 'react-icons/io5';
import { useSelector } from 'react-redux';
import { getState } from '../../store/reducers';

const StyledHeader = styled.header`
  background-color: #ffa500;
  box-shadow: 0px 3px 3px rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  box-sizing: border-box;
  position: sticky;
  top: 0;
  z-index: 2;
  height: 50px;

  .headerWrapper {
    margin-top: 3px;
    display: flex;
    justify-content: center;
    width: 100%;
    background-color: #393939;
  }

  .contentBox {
    display: flex;
    justify-content: space-between;
    align-items: center;
    max-width: 1280px;
    min-width: auto;
    width: 100%;
  }

  .inputBox {
    width: 55%;
    display: flex;
    align-items: center;
    margin: 0px 10px;

    .seacrch {
      width: 100%;
      padding-left: 5px;
      display: flex;
      align-items: center;
      border-radius: 3px;
      background-color: hsl(0, 0%, 17.5%);
      border: 1px solid hsl(210, 5.5%, 43.5%);

      path {
        fill: hsl(210, 5.5%, 43.5%);
      }

      input {
        background-color: hsl(0, 0%, 17.5%);
        color: hsl(210, 5.5%, 43.5%);
        width: 98%;
        font-size: 13px;
        padding: 0.5rem 0.6rem;
        outline: none;
        border: none;
      }
    }
  }

  .porfile {
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .profileBox {
    display: flex;
    align-items: center;
    gap: 0.5rem;
  }
`;

const LogoLink = styled(Link)`
  color: white;
  text-decoration: none;
  display: inline-block;
  height: 50px;
  line-height: 50px;
  padding: 0 15px;

  b {
    font-weight: bold;
    color: #fff;
  }
  .icon {
    font-size: larger;
  }

  display: flex;
  justify-content: center;
  align-items: center;
`;

const HeaderLink = styled(Link)`
  padding: 6px 8px;
  color: hsl(205, 46.5%, 73.5%);
  font-size: 13px;
  background-color: hsl(205, 14%, 28%);
  border-radius: 3px;
  border: 1px solid hsl(201, 41%, 63%);

  ${(props) =>
    props.action === 'signup' &&
    css`
      background-color: #0964aa;
      color: #fff;
      border: 1px solid #0964aa;
    `}
`;

function Header() {
  const loginInfo = useSelector(getState);
  console.log(loginInfo);
  return (
    <StyledHeader>
      <div className="headerWrapper">
        <div className="contentBox">
          <LogoLink to="/" className="logo">
            <BsStackOverflow className="icon" />
            <span>&nbsp;stack&nbsp;</span>
            <b> OverFlow</b>
          </LogoLink>
          <div className="inputBox">
            <form action="" className="seacrch">
              <IoSearchSharp size={20} />
              <input type="text" placeholder="search..." />
            </form>
          </div>
          <div className="profileBox">
            {loginInfo.payload.loginState.userInfo.id ? (
              'Login'
            ) : (
              <>
                <HeaderLink to="/login">Log in</HeaderLink>
                <HeaderLink to="/signup" action="signup">
                  Sign up
                </HeaderLink>
              </>
            )}
          </div>
        </div>
      </div>
    </StyledHeader>
  );
}

export default Header;
