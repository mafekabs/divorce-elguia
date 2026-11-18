package za.co.mafeka.divorceelguia.service.impl.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceRequest;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceResponse;
import za.co.mafeka.divorceelguia.mapper.LegalServiceMapper;
import za.co.mafeka.divorceelguia.model.LegalService;
import za.co.mafeka.divorceelguia.repository.LegalServiceRepository;
import za.co.mafeka.divorceelguia.service.LegalServiceService;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LegalServiceImpl implements LegalServiceService {

    private final LegalServiceRepository repository;
    private final LegalServiceMapper mapper;

    @Override
    @Transactional
    public ApiResponse<LegalServiceResponse> create(LegalServiceRequest request) {
        log.info("Creating legal service with code: {}", request.service().code());
        String code = request.service().code().trim().toUpperCase();
        if (repository.findByCode(code).isPresent()) {
            throw new EntityExistsException("LegalService with code '" + code + "' already exists");
        }

        LegalService saved = repository.save(toEntity(request, code));
        return ApiResponse.success("LegalService created successfully", toResponse(saved));
    }

    public ApiResponse<LegalServiceResponse> getById(UUID id) {
        LegalService service = findOrThrow(id);
        return ApiResponse.success("LegalService retrieved successfully", toResponse(service));
    }

    @Override
    public ApiResponse<LegalServiceResponse> getByCode(String code) {
        String normalizedCode = code.trim().toUpperCase();
        LegalService service = repository.findByCode(normalizedCode)
                .orElseThrow(() -> new EntityNotFoundException("LegalService with code '" + code + "' not found"));
        return ApiResponse.success("LegalService retrieved successfully", toResponse(service));
    }

    @Override
    public ApiResponse<LegalServiceResponse> getAllOrdered() {
        List<LegalService> services = repository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        return ApiResponse.success("All legal services retrieved successfully", toListResponse(services));
    }

    @Override
    public ApiResponse<List<LegalServiceResponse>> getAllActiveOrdered() {
        List<LegalServiceResponse> services = repository.findByIsActiveTrueOrderBySortOrderAsc().stream().map(this::toResponse).toList();
        return ApiResponse.success("Active legal legalServices retrieved successfully", services);
    }

    @Override
    @Transactional
    public ApiResponse<LegalServiceResponse> update(UUID id, LegalServiceRequest request) {
        LegalService existing = findOrThrow(id);;

        existing.setCode(request.service().code().trim().toUpperCase());
        existing.setName(request.service().name().trim());
        existing.setDescription(request.service().description());
        existing.setIsActive(request.service().isActive());
        LegalService updated = repository.save(existing);
        return ApiResponse.success("LegalService updated successfully", toResponse(updated));
    }

    @Override
    @Transactional
    public ApiResponse<LegalServiceResponse> activate(UUID id) {
        LegalService service = findOrThrow(id);
        service.setIsActive(true);
        return ApiResponse.success("LegalService activated successfully", toResponse(repository.save(service)));
    }

    @Override
    @Transactional
    public ApiResponse<LegalServiceResponse> deactivate(UUID id) {
        LegalService service = findOrThrow(id);
        service.setIsActive(false);
        return ApiResponse.success("LegalService deactivated successfully", toResponse(repository.save(service)));
    }

    @Override
    @Transactional
    public ApiResponse<Object> delete(UUID id) {
        LegalService service = findOrThrow(id);
        repository.delete(service);
        log.warn("Deleted service: {} - {}", service.getId(), service.getCode());
        return ApiResponse.success("LegalService deleted successfully", null);
    }

    private LegalService findOrThrow(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LegalService with id '" + id + "' not found"));
    }

    private LegalService toEntity(LegalServiceRequest request, String normalizedCode) {
        boolean isActive = request.service().isActive() != null ? request.service().isActive(): true;
        return LegalService.builder()
                .code(normalizedCode)
                .isActive(isActive)
                .name(request.service().name().trim())
                .description(request.service().description())
                .build();
    }

    private LegalServiceResponse toResponse(LegalService service) {
        return LegalServiceResponse.builder()
                .legalServices(List.of(mapper.toDto(service)))
                .build();
    }

    private LegalServiceResponse toListResponse(List<LegalService> services) {
        return LegalServiceResponse.builder()
                .legalServices(mapper.toDtoList(services))
                .build();
    }
}