package rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.service;

import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.entity.CameraModel;

import java.util.List;

public interface CameraModelService {

    CameraModelResponseDto create(CameraModelRequestDto requestDto);

    CameraModelResponseDto update(Long id, CameraModelRequestDto requestDto);

    CameraModelResponseDto getById(Long id);

    List<CameraModelResponseDto> getAll();

    void delete(Long id);

    CameraModel toEntity(Long id);

    Long toDto(CameraModel cameraModel);
}
