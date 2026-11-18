package za.co.mafeka.divorceelguia.service.impl.appointment;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.mafeka.divorceelguia.dto.ApiResponse;
import za.co.mafeka.divorceelguia.dto.appointment.AppointmentRequest;
import za.co.mafeka.divorceelguia.dto.appointment.AppointmentResponse;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceResponse;
import za.co.mafeka.divorceelguia.mapper.AppointmentMapper;
import za.co.mafeka.divorceelguia.model.Appointment;
import za.co.mafeka.divorceelguia.model.LegalService;
import za.co.mafeka.divorceelguia.model.Office;
import za.co.mafeka.divorceelguia.model.SeekerProfile;
import za.co.mafeka.divorceelguia.model.enums.AppointmentStatus;
import za.co.mafeka.divorceelguia.repository.AppointmentRepository;
import za.co.mafeka.divorceelguia.repository.OfficeRepository;
import za.co.mafeka.divorceelguia.repository.SeekerProfileRepository;
import za.co.mafeka.divorceelguia.service.AppointmentService;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repo;
    private final AppointmentMapper mapper;
    private final OfficeRepository officeRepo;
    private final SeekerProfileRepository seekerRepo;

    @Override
    public ApiResponse<AppointmentResponse> create(AppointmentRequest request) {
        log.info("Creating an appointment for Seeker ID: {} at the {} office.", request.appointment().seekerId(), request.appointment().officeName());

        Appointment saved = repo.save(toEntity(request));
        return ApiResponse.success("Appointment created successfully", toResponse(saved));
    }

    @Override
    public ApiResponse<AppointmentResponse> update(UUID id, AppointmentRequest request) {
        Appointment existing = findOrThrow(id);;

        existing.setOffice(getOfficeById(request.appointment().officeId()));
        existing.setSeeker(getSeekerById(request.appointment().seekerId()));
        existing.setAppointmentDate(request.appointment().dateTime());
        existing.setNotes(request.appointment().notes());
        existing.setStatus(AppointmentStatus.getByName(request.appointment().status()));

        Appointment updated = repo.save(existing);

        return ApiResponse.success("Appointment updated successfully", toResponse(updated));
    }

    @Override
    public ApiResponse<AppointmentResponse> getAllOrdered() {
        List<Appointment> appointments = repo.findAll(Sort.by(Sort.Direction.DESC, "appointmentDate"));
        return ApiResponse.success("Appointments retrieved successfully", toListResponse(appointments));
    }

    @Override
    public ApiResponse<AppointmentResponse> getById(UUID id) {
        Appointment appointment = findOrThrow(id);
        return ApiResponse.success("Appointment retrieved successfully", toResponse(appointment));
    }

    @Override
    public ApiResponse<AppointmentResponse> getByOfficeId(UUID officeId) {
        List<Appointment> appointments = repo.findByOfficeId(officeId);
        return ApiResponse.success("Appointment retrieved successfully", toListResponse(appointments));
    }

    @Override
    public ApiResponse<AppointmentResponse> getByOfficeName(String officeName) {
        List<Appointment> appointments = repo.findByOfficeName(officeName);
        return ApiResponse.success("Appointments retrieved successfully", toListResponse(appointments));
    }

    @Override
    public ApiResponse<AppointmentResponse> getByStatus(String staus) {
        List<Appointment> appointments = repo.findByStatus(staus);
        return ApiResponse.success("Appointments retrieved successfully", toListResponse(appointments));
    }

    @Override
    public ApiResponse<Object> delete(UUID id) {
        Appointment appointment = findOrThrow(id);
        repo.delete(appointment);
        log.warn("Deleted appointment: {} - {}", appointment.getId(), appointment.getId());
        return ApiResponse.success("Appointment deleted successfully", null);
    }

    private Appointment findOrThrow(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment with id '" + id + "' not found"));
    }

    private Appointment toEntity(AppointmentRequest request) {
        return Appointment.builder()
                .appointmentDate(request.appointment().dateTime())
                .office(getOfficeById(request.appointment().officeId()))
                .seeker(getSeekerById(request.appointment().seekerId()))
                .notes(request.appointment().notes())
                .build();
    }

    private AppointmentResponse toResponse(Appointment appointment) {
        return AppointmentResponse.builder()
                .appointments(List.of(mapper.toDto(appointment)))
                .build();
    }

    private AppointmentResponse toListResponse(List<Appointment> appointments) {
        return AppointmentResponse.builder()
                .appointments(mapper.toDtoList(appointments))
                .build();

    }

    public Office getOfficeById(UUID id) {
        return officeRepo.getReferenceById(id);
    }

    public SeekerProfile getSeekerById(UUID id) {
        return seekerRepo.getReferenceById(id);
    }
}