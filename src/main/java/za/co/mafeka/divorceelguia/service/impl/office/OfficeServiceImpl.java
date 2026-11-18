package za.co.mafeka.divorceelguia.service.impl.office;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.office.OfficeRequest;
import za.co.mafeka.divorceelguia.dto.office.OfficeResponse;
import za.co.mafeka.divorceelguia.mapper.OfficeMapper;
import za.co.mafeka.divorceelguia.model.Office;
import za.co.mafeka.divorceelguia.model.enums.OfficeType;
import za.co.mafeka.divorceelguia.repository.OfficeRepository;
import za.co.mafeka.divorceelguia.service.OfficeService;

import java.util.List;
import java.util.UUID;


@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository repository;
    private OfficeMapper mapper;

    @Override
    @org.springframework.transaction.annotation.Transactional
    public ApiResponse<OfficeResponse> create(OfficeRequest request) {
        log.info("Creating Office with name: {}", request.office().name());

        Office saved = repository.save(toEntity(request));
        return ApiResponse.success("Office created successfully", toResponse(saved));
    }

    public ApiResponse<OfficeResponse> getById(UUID id) {
        Office service = findOrThrow(id);
        return ApiResponse.success("Office retrieved successfully", toResponse(service));
    }

    @Override
    public ApiResponse<OfficeResponse> getAllOrdered() {
        List<Office> services = repository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        return ApiResponse.success("All legal services retrieved successfully", toListResponse(services));
    }

    @Override
    public ApiResponse<List<OfficeResponse>> getAllActiveOrdered() {
        List<OfficeResponse> services = repository.findByIsActiveTrueOrderByNameAsc().stream().map(this::toResponse).toList();
        return ApiResponse.success("Active Office retrieved successfully", services);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public ApiResponse<OfficeResponse> update(UUID id, OfficeRequest request) {
        Office existing = findOrThrow(id);;
        mapper.updateEntityFromDto(request, existing);

        Office updated = repository.save(existing);

        return ApiResponse.success("Office updated successfully", toResponse(updated));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public ApiResponse<OfficeResponse> activate(UUID id) {
        Office service = findOrThrow(id);
        service.setIsActive(true);
        return ApiResponse.success("Office activated successfully", toResponse(repository.save(service)));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public ApiResponse<OfficeResponse> deactivate(UUID id) {
        Office service = findOrThrow(id);
        service.setIsActive(false);
        return ApiResponse.success("Office deactivated successfully", toResponse(repository.save(service)));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public ApiResponse<Object> delete(UUID id) {
        Office office = findOrThrow(id);
        repository.delete(office);
        log.warn("Deleted office: {}, named: {}", office.getId(), office.getName());
        return ApiResponse.success("Office deleted successfully", null);
    }

    private Office findOrThrow(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Office with id '" + id + "' not found"));
    }

    private Office toEntity(OfficeRequest request) {
        boolean isActive = request.office().isActive() != null ? request.office().isActive(): true;
        return Office.builder()
                .isActive(isActive)
                .name(request.office().name().trim())
                .type(OfficeType.getByType(request.office().type()))
                .description(request.office().description())
                .addressLine1(request.office().addressLine1())
                .emailAddress(request.office().emailAddress())
                .capacityNotes(request.office().capacityNotes())
                .languagesSpoken(request.office().languagesSpoken())
                .operatingHours(request.office().operatingHours())
                .phone(request.office().phoneNumber())
                .city(request.office().town())
                .province(request.office().province())
                .gpsLat(request.office().gpsLat())
                .gpsLng(request.office().gpsLng())
                .website(request.office().website())
                .whatsapp(request.office().whatsapp())
                .whatTheyDo(request.office().whatTheyDo())
                .whatTheyDontDo(request.office().whatTheyDontDo())
                .build();
    }

    private OfficeResponse toResponse(Office office) {
        return OfficeResponse.builder()
                .offices(List.of(mapper.toDto(office)))
                .build();
    }

    private OfficeResponse toListResponse(List<Office> services) {
        return OfficeResponse.builder()
                .offices(mapper.toDtoList(services))
                .build();
    }
}
