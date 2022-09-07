/* eslint-disable no-unused-expressions */
/* eslint-disable import/prefer-default-export */
import axios from "axios";
import { setCookie } from "../utils/cookies";

export const login = async (payload) => {
    try {
        const response = await axios.post('/api/v1/users/login', payload, {withCredentials: true})
            .then((res) => {
                if(res.status === 200) {
                    console.log(res.headers)
                    setCookie('accessToken', res.headers.access_token);
                    setCookie('refreshToken', res.headers.refresh_token);
                }
                return res;
            });
            return response;
    }catch(err) {
        throw Error(err.response.data.message);
    } 
};

export const getQuestions = async () => {
    const { data } = await axios.get('/api/v1/questions?page=1&size=10', {
        withCredentials: true,
    });

    return data;
};