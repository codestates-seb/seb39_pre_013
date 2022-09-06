package com.codestates.server.user.service;

import com.codestates.server.user.dto.UserPatchDto;
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

    public User updateUser(long id, UserPatchDto user){
        User originUser = findUser(id).orElseThrow();
        Optional.ofNullable(user.getNickname())
                .ifPresent(originUser::setNickname);
        Optional.ofNullable(user.getTitle())
                .ifPresent(originUser::setTitle);
        Optional.ofNullable(user.getLocation())
                .ifPresent(originUser::setLocation);
        Optional.ofNullable(user.getAboutMe())
                .ifPresent(originUser::setAboutMe);
        Optional.ofNullable(user.getGithubLink())
                .ifPresent(originUser::setGithubLink);
        Optional.ofNullable(user.getTwitterLink())
                .ifPresent(originUser::setTwitterLink);
        Optional.ofNullable(user.getWebsiteLink())
                .ifPresent(originUser::setWebsiteLink);
        return originUser;
    }
    public Page<User> findUsers(int page, int pageSize) {
        //유저 태그에 대한 정보를 갖는다.

        return userRepository.findAll(PageRequest.of(page, pageSize, Sort.by("id").ascending()));
    }
}
