/* eslint-disable consistent-return */
/* eslint-disable import/no-cycle */
/* eslint-disable import/prefer-default-export */

import axios from "axios";
import { Cookies } from "react-cookie";
import { deleteCookie, getCookie, setCookie } from "./cookies";
import { persistor } from "../index";

const cookies = new Cookies();

export const authUser = async () => {
    const accesstoken = { access_token: getCookie('accessToken') };
    const refreshtoken = { refresh_token: getCookie('refreshToken') };
    
    if(!accesstoken || !refreshtoken) {
        console.log('not found token')
        return false;
    }

    const res = await axios.get('/api/v1/users/auth', {headers: {
        access_token: accesstoken.access_token,
        refresh_token: refreshtoken.refresh_token
    }}, {withCredentials: true});
    console.log('data :', res)
    return res;
}

export const removeToken = () => {
    cookies.remove('access_token');
    cookies.remove('refresh_token');
};

