package za.co.mafeka.divorceelguia.service;

import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.office.OfficeRequest;
import za.co.mafeka.divorceelguia.dto.office.OfficeResponse;

import java.util.List;
import java.util.UUID;

public interface OfficeService {
    ApiResponse<OfficeResponse> create(OfficeRequest request);
    ApiResponse<OfficeResponse> update(UUID id, OfficeRequest request);
    ApiResponse<OfficeResponse> getById(UUID id);
    ApiResponse<OfficeResponse> getAllOrdered();
    ApiResponse<List<OfficeResponse>> getAllActiveOrdered();
    ApiResponse<OfficeResponse> activate(UUID id);
    ApiResponse<OfficeResponse> deactivate(UUID id);
    ApiResponse<Object> delete(UUID id);
}
