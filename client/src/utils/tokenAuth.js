/* eslint-disable function-paren-newline */
/* eslint-disable import/prefer-default-export */
/* eslint-disable no-param-reassign */
/* eslint-disable prefer-arrow-callback */
import axios from 'axios';
import { Cookies } from 'react-cookie';
import { getCookie } from './cookies';

const cookies = new Cookies();

const axiosInstance = axios.create({
  baseURL: 'http://pre13.duckdns.org:81',
  withCredentials: true,
});

export const setToken = (accessToken, refreshToken) => {
  if (accessToken && refreshToken) {
    cookies.set('access_token', accessToken);
    cookies.set('refresh_token', refreshToken);
    axiosInstance.defaults.headers.access_token = accessToken;
    axiosInstance.defaults.headers.refresh_token = refreshToken;
  }
};

// export const removeToken = () => {
//   cookies.remove('access_token');
//   cookies.remove('refresh_token');
//   axiosInstance.defaults.headers.access_token = null;
//   axiosInstance.defaults.headers.refresh_token = null;
// };

axiosInstance.interceptors.request.use(async (config) => {
  const accessToken = getCookie('access_token');
  const refreshToken = getCookie('refresh_token');

  if (accessToken && refreshToken) {
    config.headers.access_token = accessToken;
    config.headers.refresh_token = refreshToken;
  }
  config.headers['Content-Type'] = 'application/json';
  config.withCredentials = true;

  return config;
});

axiosInstance.interceptors.response.use(
  (response) => response,

  async (error) => {
    const {
      config,
      response: { status },
    } = error;

    if (status === 403) {
      const originalReq = config;
      const refreshToken = getCookie('refresh_token');
      const { data } = await axios.get('/api/v1/users/refresh');
    }
  },
);

export default axiosInstance;
