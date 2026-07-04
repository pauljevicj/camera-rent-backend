package rs.ac.bg.fon.camerarentbackend.core.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rs.ac.bg.fon.camerarentbackend.core.user.dto.UserRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.user.dto.UserResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toResponseDto(User user);

    User toEntity(UserRequestDto requestDto);

    void update(@MappingTarget User user, UserRequestDto requestDto);
}

