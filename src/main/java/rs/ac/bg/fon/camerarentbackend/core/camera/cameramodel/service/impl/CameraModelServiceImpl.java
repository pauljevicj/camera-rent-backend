package rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.dto.CameraModelResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.mapper.CameraModelMapper;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.repository.CameraModelRepository;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.service.CameraModelService;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.entity.CameraModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CameraModelServiceImpl implements CameraModelService {

    private final CameraModelRepository cameraModelRepository;
    private final CameraModelMapper cameraModelMapper;

    @Override
    public CameraModelResponseDto create(CameraModelRequestDto requestDto) {
        CameraModel cameraModel = cameraModelMapper.toEntity(requestDto);
        CameraModel savedCameraModel = cameraModelRepository.save(cameraModel);
        return cameraModelMapper.toResponseDto(savedCameraModel);
    }

    @Override
    public CameraModelResponseDto update(Long id, CameraModelRequestDto requestDto) {
        CameraModel cameraModel = cameraModelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CameraModel not found with id: " + id));
        cameraModel.setBrand(requestDto.brand());
        cameraModel.setModel(requestDto.model());
        CameraModel updatedCameraModel = cameraModelRepository.save(cameraModel);
        return cameraModelMapper.toResponseDto(updatedCameraModel);
    }

    @Override
    public CameraModelResponseDto getById(Long id) {
        CameraModel cameraModel = cameraModelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CameraModel not found with id: " + id));
        return cameraModelMapper.toResponseDto(cameraModel);
    }

    @Override
    public List<CameraModelResponseDto> getAll() {
        return cameraModelRepository.findAll()
                .stream()
                .map(cameraModelMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        cameraModelRepository.deleteById(id);
    }
}
