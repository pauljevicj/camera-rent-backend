package rs.ac.bg.fon.camerarentbackend.core.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.user.dto.UserRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.user.dto.UserResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.user.entity.User;
import rs.ac.bg.fon.camerarentbackend.core.user.mapper.UserMapper;
import rs.ac.bg.fon.camerarentbackend.core.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto create(UserRequestDto requestDto) {
        User savedUser = userRepository.save(userMapper.toEntity(requestDto));
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        userMapper.update(user, requestDto);
        return userMapper.toResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        return userMapper.toResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
