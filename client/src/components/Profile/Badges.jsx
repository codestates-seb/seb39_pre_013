import React from 'react';
import styled from 'styled-components';
import ProfileTitle from './UI/ProfileTitle';

const BadgesDiv = styled.div`
    margin-top: 10px;
    border: 2px solid red;
`;

const BadgesContainer = styled.div`
    font-size: 16px;
    font-weight: bold;
    width:100%;
    border: 2px solid white;
    border-radius: 10px;
    box-sizing:border-box;
    padding:5px 5px;
    display:flex;
    justify-content:space-between;
    align-items:center;
`;


const Badgeblock = styled.div`
    border:2px solid snow;
    height: 180px;
    width: 32%;
    border-radius:10px;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items: center;
    >div{
        height:32%;
        display:flex;
        align-items:center;
    }
`



function Badges(){
    return (
        <BadgesDiv>
          <ProfileTitle>Badges</ProfileTitle>
          <BadgesContainer>
           <Badgeblock>
            <div>뱃지 이미지</div>
            <div>설명</div>
            <div>브라우즈 링크</div>
           </Badgeblock>
           <Badgeblock>
            <div>뱃지 이미지</div>
            <div>설명</div>
            <div>브라우즈 링크</div>
           </Badgeblock>
           <Badgeblock> 
            <div>뱃지 이미지</div>
            <div>설명</div>
            <div>브라우즈 링크</div></Badgeblock>
          </BadgesContainer>
          
        </BadgesDiv>
    )
}

export default Badges;