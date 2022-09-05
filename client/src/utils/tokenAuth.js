/* eslint-disable import/prefer-default-export */
/* eslint-disable no-param-reassign */
/* eslint-disable prefer-arrow-callback */
import axios from "axios";
import { Cookies } from "react-cookie";

const cookies = new Cookies();

const axiosInstance = axios.create({
    baseURL: 'http://pre13.duckdns.org:81'
})

export const setToken = (accessToken, refreshToken) => {
    if(accessToken && refreshToken) {
        cookies.set('access_token', accessToken);
        cookies.set('refresh_token', refreshToken);
        axiosInstance.defaults.headers.access_token = accessToken;
        axiosInstance.defaults.headers.refresh_token = refreshToken; 
    }
};

export const removeToken = () => {
    cookies.remove('access_token');
    cookies.remove('refresh_token');
    axiosInstance.defaults.headers.access_token = null;
    axiosInstance.defaults.headers.refresh_token = null;
};

