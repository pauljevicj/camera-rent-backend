package rs.ac.bg.fon.camerarentbackend.core.camera.mapper;

import org.mapstruct.Mapper;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;

@Mapper(componentModel = "spring")
public interface CameraMapper {

    CameraResponseDto toResponseDto(Camera camera);

    Camera toEntity(CameraRequestDto requestDto);
}
