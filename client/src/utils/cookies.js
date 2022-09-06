import { Cookies } from 'react-cookie';

const cookies = new Cookies();

// eslint-disable-next-line import/prefer-default-export
export const setCookie = (name, value, _option=null) => cookies.set(name, value, {..._option});

export const getCookie = (name) => cookies.get(name);

export const deleteCookie = (name) => cookies.remove(name);