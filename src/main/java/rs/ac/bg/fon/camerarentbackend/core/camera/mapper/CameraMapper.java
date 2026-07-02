package rs.ac.bg.fon.camerarentbackend.core.camera.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;

@Mapper(componentModel = "spring")
public interface CameraMapper {

    CameraResponseDto toResponseDto(Camera camera);

    Camera toEntity(CameraRequestDto requestDto);

    void update(@MappingTarget Camera camera, CameraRequestDto requestDto);
}
