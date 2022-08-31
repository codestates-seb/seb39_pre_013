/* eslint-disable function-paren-newline */
import axios from 'axios';
import React from 'react';
import { useQuery } from 'react-query';
import styled from 'styled-components';
import Loading from '../components/Common/Loading';
import UserCard from '../components/Users/UserCard';

export default function UsersPage() {
  const getUsers = async () => {
    const { data } = await axios.get(
      'https://api.stackexchange.com/2.3/users?page=1&pagesize=40&order=desc&sort=reputation&site=stackoverflow',
    );
    return data;
  };

  const { data, isFetching } = useQuery('getUsers', getUsers, {
    refetchOnWindowFocus: false,
  });

  if (isFetching) {
    return <Loading />;
  }
  return (
    <Container>
      {data.items.map((v) => (
        <UserCard
          key={v.account_id}
          name={v.display_name}
          profileImg={v.profile_image}
          location={v.location}
          rate={v.accept_rate}
        />
      ))}
    </Container>
  );
}

const Container = styled.section`
  display: flex;
  gap: 3rem;
  justify-content: flex-start;
  align-items: center;
  flex-wrap: wrap;
`;
