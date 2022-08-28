import React from 'react';
import styled from 'styled-components';
import { BsStackOverflow } from 'react-icons/bs';

const StyledHeader = styled.header`
    background-color: #393939;
    box-shadow: 0px 3px 3px rgba(0, 0, 0, .3);
    display:flex;
    justify-content:center;
    box-sizing: border-box;

    .contentBox{
        width: 70%;
        display:flex;

    }

    .inputBox{
        width: 55%;
        
        display: flex;
        align-items: center;
        margin: 0px 10px;

        .seacrch{
            width: 100%;
           
            input{
                width: 98%;
                font-size: 1.5rem
            }
        }
    }

    .porfile{
        color:white;
        display:flex;
        align-items: center;
        justify-content:center;
    }

    .profileBox{
        display:flex;
        align-items: center;
    }

    


`;

const LogoLink = styled.a`
    color: white;
    text-decoration: none;
    display: inline-block;
    height: 50px;
    line-height: 50px;
    padding: 0 15px;
    width: 20%;
  
    b{
        font-weight: bold;
        color: #fff;
        
    }
   .icon{
    font-size: larger;
   }
   
    display: flex;
    justify-content: center;
    align-items: center;
`;

function Header() {
  return (
    <StyledHeader>
      <div className="contentBox">
        <LogoLink href="#" className="logo">
          <BsStackOverflow className="icon" />
          <span>&nbsp;stack&nbsp;</span>
          <b> OverFlow</b>
        </LogoLink>
        <div className="inputBox">
          <form action="" className="seacrch">
            <input type="text" placeholder="search..." />
          </form>
        </div>
        <div className="profileBox">

          <a href="//" className="porfile">RAK</a>
        </div>
      </div>
    </StyledHeader>
  );
}

export default Header;
