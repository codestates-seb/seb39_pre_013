/* eslint-disable no-empty-pattern */
/* eslint-disable no-return-assign */
/* eslint-disable function-paren-newline */
/* eslint-disable jsx-a11y/label-has-associated-control */
import React, { useState } from 'react';
import { useMutation } from 'react-query';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { login } from '../Api/apiIndex';
import { loginActions } from '../store/reducers';

export default function LoginPage() {
  const [loginData, setLoginData] = useState({ email: '', password: '' });
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const inputChangeHandler = (e) => {
    // eslint-disable-next-line no-param-reassign
    setLoginData((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const loginAction = useMutation('login', login, {
    onSuccess: (data) => {
      console.log('login data :', data);
      dispatch(loginActions(data.data.data));
      navigate(-1);
    },
  });

  const loginButtonHandler = async (e) => {
    e.preventDefault();
    loginAction.mutateAsync({
      email: loginData.email,
      password: loginData.password,
    });
  };

  return (
    <Container>
      <LoginBox>
        <svg
          aria-hidden="true"
          className="native svg-icon iconLogoGlyphMd"
          width="32"
          height="37"
          viewBox="0 0 32 37"
        >
          <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB" />
          <path
            d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z"
            fill="#F48024"
          />
        </svg>
        <OauthButton type="button" with="google">
          Log in with Google
        </OauthButton>
        <OauthButton type="button" with="github">
          Log in with Github
        </OauthButton>
        <OauthButton type="button" with="facebook">
          Log in with Facebook
        </OauthButton>
        <LoginForm onSubmit={loginButtonHandler}>
          <div>
            <label htmlFor="input_email">Email</label>
            <input
              onChange={inputChangeHandler}
              type="text"
              id="input_email"
              name="email"
              value={loginData.email}
            />
          </div>
          <div>
            <label htmlFor="input_password">Password</label>
            <input
              onChange={inputChangeHandler}
              type="password"
              id="input_password"
              name="password"
              value={loginData.password}
            />
          </div>
          <button type="submit">Login</button>
        </LoginForm>
      </LoginBox>
    </Container>
  );
}

const Container = styled.section`
  width: 100%;
  padding: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const LoginBox = styled.article`
  max-width: 300px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.6rem;

  svg {
    margin-bottom: 1rem;
  }
`;

const OauthButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  padding: 0.8rem;
  font-size: 13px;
  cursor: pointer;
`;

const LoginForm = styled.form`
  padding: 24px;
  display: flex;
  flex-direction: column;
  box-shadow: 0 10px 24px hsla(0, 0%, 0%, 0.05),
    0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);

  > div {
    display: flex;
    flex-direction: column;

    input {
      width: 100%;
      padding: 0.6rem 0.7rem;
      border: 1px solid hsl(210, 8%, 75%);
    }
  }
`;
