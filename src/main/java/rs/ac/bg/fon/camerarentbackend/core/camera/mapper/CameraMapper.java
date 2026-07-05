package rs.ac.bg.fon.camerarentbackend.core.camera.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.service.CameraModelService;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;

@Mapper(componentModel = "spring", uses = {CameraModelService.class})
public interface CameraMapper {

    @Mapping(target = "cameraModel", source = "cameraModel.id")
    CameraResponseDto toResponseDto(Camera camera);

    @Mapping(target = "cameraModel", source = "cameraModelId")
    Camera toEntity(CameraRequestDto requestDto);

    void update(@MappingTarget Camera camera, CameraRequestDto requestDto);
}
