package rs.ac.bg.fon.camerarentbackend.core.user.service;

import rs.ac.bg.fon.camerarentbackend.core.user.dto.UserRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto create(UserRequestDto requestDto);

    UserResponseDto update(Long id, UserRequestDto requestDto);

    UserResponseDto getById(Long id);

    List<UserResponseDto> getAll();

    void delete(Long id);
}
