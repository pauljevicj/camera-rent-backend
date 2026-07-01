package rs.ac.bg.fon.camerarentbackend.core.camera.service;

import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;

import java.util.List;

public interface CameraService {

    CameraResponseDto create(CameraRequestDto requestDto);

    CameraResponseDto update(Long id, CameraRequestDto requestDto);

    CameraResponseDto getById(Long id);

    List<CameraResponseDto> getAll();

    void delete(Long id);
}
