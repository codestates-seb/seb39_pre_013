/* eslint-disable no-unused-expressions */
/* eslint-disable import/prefer-default-export */
import axios from "axios";
import { setCookie } from "../utils/cookies";

export const login = async (payload) => {
    try {
        const response = await axios.post('/api/v1/users/login', payload, {withCredentials: true})
            .then((res) => {
                if(res.status === 200) {
                    setCookie('accessToken', res.headers.accesstoken);
                    setCookie('refreshToken', res.headers.refreshtoken);
                }
                return payload;
            });
            console.log('inner API :', response);
            return response.email;
    }catch(err) {
        throw Error(err.response.data.message);
    } 
};

