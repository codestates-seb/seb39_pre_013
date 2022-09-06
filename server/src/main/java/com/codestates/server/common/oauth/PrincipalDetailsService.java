package com.codestates.server.common.oauth;

import com.codestates.server.user.entity.User;
import com.codestates.server.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public PrincipalDetailsService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 이메일입니다."));
//        System.out.println(userEntity.toString());
//        System.out.println(userEntity.getAnswers());
//        System.out.println(userEntity.getQuestions());
//        System.out.println(userEntity.getUserTags());
//        System.out.println(userEntity.getSubscribes());
        return new PrincipalDetails(userEntity);
    }
}
