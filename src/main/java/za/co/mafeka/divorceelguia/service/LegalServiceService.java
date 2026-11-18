package za.co.mafeka.divorceelguia.service;

import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceRequest;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceResponse;
import java.util.List;
import java.util.UUID;

public interface LegalServiceService {
    ApiResponse<LegalServiceResponse> create(LegalServiceRequest request);
    ApiResponse<LegalServiceResponse> update(UUID id, LegalServiceRequest request);
    ApiResponse<LegalServiceResponse> getById(UUID id);
    ApiResponse<LegalServiceResponse> getByCode(String code);
    ApiResponse<LegalServiceResponse> getAllOrdered();
    ApiResponse<List<LegalServiceResponse>> getAllActiveOrdered();
    ApiResponse<LegalServiceResponse> activate(UUID id);
    ApiResponse<LegalServiceResponse> deactivate(UUID id);
    ApiResponse<Object> delete(UUID id);
}