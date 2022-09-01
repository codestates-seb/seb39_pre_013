import React from 'react';
import styled from 'styled-components';
import Header from "../components/Common/Header"
import NavBar from '../components/Common/NavBar';
import Summary from '../components/Profile/Summary';
import ProfileTitle from '../components/Profile/UI/ProfileTitle';
import Stats from "../components/Profile/Stats";
import Communities from '../components/Profile/Communities';
import About from '../components/Profile/About';
import Badges from '../components/Profile/Badges';
import Posts from "../components/Profile/Posts";



const ProfileContent = styled.div`
    display: flex;
    flex-direction: column;
    height: 90vh;

    .Profile__profile{
      border: 2px solid white;
      height: 150px;
      display: flex;
      align-items: center;
      padding: 5px 5px;
      
      .Profile__image{
          width:140px;
          height:130px;
          border: 2px solid teal;
          border-radius: 10px;
      }

      .Profile__info{
        display:flex;   
        width: 100%;
        flex-direction: column;
        justify-content:center;
        div{
          border:2px solid white;
          font-size: 20px;
          margin: 3px 0;
          &:first-child{
              display: flex;
          }
        }      
      }


      
    }

    .Profile--navBar{
      display:flex;
      margin-bottom: 10px;;
      width:100%;
      .Profile--navBar__item{
        padding:5px 7px;
        margin: 5px 5px;
        border:2px solid tomato;
        border-radius: 15px;
      }
    }

    .main{
      border: 2px solid tomato;
      width: 100%;
      display:flex;

      .main_left{
        width:27%;
      }

      .main-right{
        width:73%;
        border:4px solid turquoise;
      }

    }

`;

function Profile() {
  return(
    <ProfileContent>
      <div className="Profile__profile">
        <div className='Profile__image'>이미지</div>
        <div className='Profile__info'>
          <div>
            <div>Edit profile</div>
              <div>Netwok Profile</div>
          </div>
          <div className='Profile__info__name'>하키</div>
          <div>각종 날짜정보</div>
        </div>
      </div>
      <div className='Profile--navBar'>
        <div className='Profile--navBar__item'>Profile</div>
        <div className='Profile--navBar__item'>Activity</div>
        <div className='Profile--navBar__item'>Settings</div>
      </div>
      <div className='main'>
        <div className='main_left'>
          <Stats />
          <Communities />
        </div>
        <div className='main-right'>
          <About/>
          <Badges/>
          <Posts />
        </div>
      </div>
    </ProfileContent>
  )
}

export default Profile;