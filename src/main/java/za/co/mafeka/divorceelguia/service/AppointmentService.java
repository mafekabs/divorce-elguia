package za.co.mafeka.divorceelguia.service;

import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.appointment.AppointmentRequest;
import za.co.mafeka.divorceelguia.dto.appointment.AppointmentResponse;

import java.util.UUID;

public interface AppointmentService {
    ApiResponse<AppointmentResponse> create(AppointmentRequest request);
    ApiResponse<AppointmentResponse> update(UUID id, AppointmentRequest request);
    ApiResponse<AppointmentResponse> getAllOrdered();
    ApiResponse<AppointmentResponse> getById(UUID id);
    ApiResponse<AppointmentResponse> getByOfficeId(UUID officeId);
    ApiResponse<AppointmentResponse> getByOfficeName(String officeName);
    ApiResponse<AppointmentResponse> getByStatus(String staus);
    ApiResponse<Object> delete(UUID id);
}