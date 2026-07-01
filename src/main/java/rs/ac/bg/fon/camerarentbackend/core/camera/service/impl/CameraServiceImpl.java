package rs.ac.bg.fon.camerarentbackend.core.camera.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.repository.CameraModelRepository;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.entity.CameraModel;
import rs.ac.bg.fon.camerarentbackend.core.camera.mapper.CameraMapper;
import rs.ac.bg.fon.camerarentbackend.core.camera.repository.CameraRepository;
import rs.ac.bg.fon.camerarentbackend.core.camera.service.CameraService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CameraServiceImpl implements CameraService {

    private final CameraRepository cameraRepository;
    private final CameraModelRepository cameraModelRepository;
    private final CameraMapper cameraMapper;

    @Override
    public CameraResponseDto create(CameraRequestDto requestDto) {
        Camera camera = new Camera();
        camera.setStatus(requestDto.status());
        camera.setPricePerDay(requestDto.pricePerDay());
        camera.setCameraCondition(requestDto.cameraCondition());
        camera.setYear(requestDto.year());
        
        CameraModel cameraModel = cameraModelRepository.findById(requestDto.cameraModelId())
                .orElseThrow(() -> new IllegalArgumentException("CameraModel not found with id: " + requestDto.cameraModelId()));
        camera.setCameraModel(cameraModel);
        
        Camera savedCamera = cameraRepository.save(camera);
        return cameraMapper.toResponseDto(savedCamera);
    }

    @Override
    public CameraResponseDto update(Long id, CameraRequestDto requestDto) {
        Camera camera = cameraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Camera not found with id: " + id));
        
        camera.setStatus(requestDto.status());
        camera.setPricePerDay(requestDto.pricePerDay());
        camera.setCameraCondition(requestDto.cameraCondition());
        camera.setYear(requestDto.year());
        
        CameraModel cameraModel = cameraModelRepository.findById(requestDto.cameraModelId())
                .orElseThrow(() -> new IllegalArgumentException("CameraModel not found with id: " + requestDto.cameraModelId()));
        camera.setCameraModel(cameraModel);
        
        Camera updatedCamera = cameraRepository.save(camera);
        return cameraMapper.toResponseDto(updatedCamera);
    }

    @Override
    public CameraResponseDto getById(Long id) {
        Camera camera = cameraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Camera not found with id: " + id));
        return cameraMapper.toResponseDto(camera);
    }

    @Override
    public List<CameraResponseDto> getAll() {
        return cameraRepository.findAll()
                .stream()
                .map(cameraMapper::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        cameraRepository.deleteById(id);
    }
}
