package rs.ac.bg.fon.camerarentbackend.core.camera.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.camerarentbackend.core.camera.cameramodel.repository.CameraModelRepository;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraRequestDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.dto.CameraResponseDto;
import rs.ac.bg.fon.camerarentbackend.core.camera.entity.Camera;
import rs.ac.bg.fon.camerarentbackend.core.camera.mapper.CameraMapper;
import rs.ac.bg.fon.camerarentbackend.core.camera.repository.CameraRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CameraServiceImpl implements CameraService {

    private final CameraRepository cameraRepository;
    private final CameraModelRepository cameraModelRepository;
    private final CameraMapper cameraMapper;

    @Override
    public CameraResponseDto create(CameraRequestDto requestDto) {
        Camera savedCamera = cameraRepository.save(cameraMapper.toEntity(requestDto));
        return cameraMapper.toResponseDto(savedCamera);
    }

    @Override
    public CameraResponseDto update(Long id, CameraRequestDto requestDto) {
        Camera camera = cameraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Camera not found with id: " + id));

        cameraMapper.update(camera, requestDto);
        return cameraMapper.toResponseDto(cameraRepository.save(camera));
    }

    @Override
    public CameraResponseDto getById(Long id) {
        return cameraMapper.toResponseDto(cameraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Camera not found with id: " + id)));
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
        if (!cameraRepository.existsById(id)) {
//            throw new RuntimeException(Camera.class.getSimpleName(), "id", id.toString());
        }
        cameraRepository.deleteById(id);
    }

    @Override
    public List<CameraResponseDto> getAvailableCameras(LocalDate start, LocalDate end) {

        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }

        return cameraRepository.findAvailableCameras(start, end).stream()
                .map(cameraMapper::toResponseDto)
                .toList();
    }
}
