package com.jumjari.zobiac.mapper;

import com.jumjari.zobiac.VO.Member;
import com.jumjari.zobiac.VO.UserResponseDTO;
import com.jumjari.zobiac.VO.UserSignupRequestDTO;
import com.jumjari.zobiac.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-30T00:14:22+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserSignupRequestDTO toSignDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserSignupRequestDTO userSignupRequestDTO = new UserSignupRequestDTO();

        return userSignupRequestDTO;
    }

    @Override
    public UserResponseDTO toResponseDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        return userResponseDTO;
    }

    @Override
    public Member toMemberDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Member member = new Member();

        return member;
    }

    @Override
    public User toEntity(UserResponseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.getId() );
        user.username( dto.getUsername() );
        user.nickname( dto.getNickname() );
        user.blind( dto.isBlind() );
        user.role( dto.getRole() );

        return user.build();
    }
}
