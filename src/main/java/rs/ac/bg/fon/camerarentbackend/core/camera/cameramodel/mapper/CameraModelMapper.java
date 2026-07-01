package rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.mapper;

import org.mapstruct.Mapper;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.entity.CameraModel;

@Mapper(componentModel = "spring")
public interface CameraModelMapper {

    CameraModelResponseDto toResponseDto(CameraModel cameraModel);

    CameraModel toEntity(CameraModelRequestDto requestDto);
}
