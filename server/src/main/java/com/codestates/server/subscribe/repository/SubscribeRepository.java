package com.codestates.server.subscribe.repository;

import com.codestates.server.subscribe.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe,Long> {
}
