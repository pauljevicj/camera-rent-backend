package rs.ac.bg.fon.camerarentbackend.core.camera.mapper;

import org.mapstruct.Mapper;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.entity.CameraModel;

@Mapper(componentModel = "spring")
public interface CameraMapper {

    CameraResponseDto toResponseDto(Camera camera);

    default Camera toEntity(CameraRequestDto requestDto) {
        Camera camera = new Camera();
        camera.setStatus(requestDto.status());
        camera.setPricePerDay(requestDto.pricePerDay());
        camera.setCameraCondition(requestDto.cameraCondition());
        camera.setYear(requestDto.year());
        
        CameraModel cameraModel = new CameraModel();
        cameraModel.setId(requestDto.cameraModelId());
        camera.setCameraModel(cameraModel);
        
        return camera;
    }
}
