package com.example.controller.mapper;

import com.example.controller.dto.UserPostDto;
import com.example.controller.dto.UserResponseDto;
import com.example.controller.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-26T16:02:06+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.16 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoToUser(UserPostDto userpostdto) {
        if ( userpostdto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( userpostdto.getName() );
        user.email( userpostdto.getEmail() );
        user.title( userpostdto.getTitle() );

        return user.build();
    }

    @Override
    public UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto.UserResponseDtoBuilder userResponseDto = UserResponseDto.builder();

        userResponseDto.aboutMe( user.getAboutMe() );
        userResponseDto.location( user.getLocation() );
        userResponseDto.websiteLink( user.getWebsiteLink() );
        userResponseDto.twitterLink( user.getTwitterLink() );
        userResponseDto.githubLink( user.getGithubLink() );
        userResponseDto.role( user.getRole() );
        userResponseDto.reputation( user.getReputation() );

        return userResponseDto.build();
    }
}
