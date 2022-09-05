/* eslint-disable consistent-return */
/* eslint-disable import/no-cycle */
/* eslint-disable import/prefer-default-export */

import axios from "axios";
import { deleteCookie, getCookie, setCookie } from "./cookies";
import { persistor } from "../index";

export const authUser = async () => {
    let data;
    const accesstoken = { access_token: getCookie('accessToken') };
    const refreshtoken = { refresh_token: getCookie('refreshToken') };
    
    if(!accesstoken.access_token) {
        return false;
    }

    const accessAuth = await axios.get('/api/v1/users/auth',
        { headers: accesstoken },
        {
          withCredentials: true,
        });
        console.log('ac :', accessAuth)
    if(!accessAuth.data.id) {
        const refreshAuth = await axios.get('/api/v1/users/refresh',
        { headers: refreshtoken },
        {
            withCredentials: true
        }).then(res => {
            console.log('res :', res);
            if(res.status === 200) {
                setCookie('accessToken', res.headers.accesstoken);
                setCookie('refreshToken', res.headers.refreshtoken);
                return res.data;
            }
        }).catch(async err => {
            deleteCookie('accessToken');
            deleteCookie('refreshToken');

            await persistor.purge();
            console.log('err')
            return false;
        });
    }
        return accessAuth.data;
    
};