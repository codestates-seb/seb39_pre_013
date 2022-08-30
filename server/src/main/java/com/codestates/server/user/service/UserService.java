package com.codestates.server.user.service;

import com.codestates.server.user.entity.User;
import com.codestates.server.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> findUser(Long userId){
        return userRepository.findById(userId);
    }

    public Page<User> findUsers(int page, int pageSize) {
        return userRepository.findAll(PageRequest.of(page, pageSize, Sort.by("id").descending()));
    }
}
