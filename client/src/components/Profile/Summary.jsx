import React from 'react';
import styled from 'styled-components';

const SummaryBox = styled.div`
    width:100%;
    height: 250px;
    border: 2px solid whitesmoke;
    box-sizing: border-box;
    padding: 5px 5px;

    .Summary-title{
        font-size: 25px;
        font-weight: bold;
    }

    .Summary-main{
        display:flex;
        div{
            &:nth-child(1){
                margin-top:5px;
                margin-right:5px;
                width:40%;
                height: 200px;
                border: 2px solid white;
            }
            &:nth-child(2){
                margin-top:5px;
                margin-right:5px;
                width:35%;
                height: 200px;
                border: 2px solid white;
            }
            &:nth-child(3){
                margin-top:5px;
                width:25%;
                height: 200px;
                border: 2px solid white;
            }
        }
    }
    
`

function Summary(){
    return (
        <SummaryBox>
            <div className='Summary-title'>Summary</div>
            <div className='Summary-main'>
                <div>box</div>
                <div>box</div>
                <div>box</div>
            </div>
        </SummaryBox>
    )
}

export default Summary;