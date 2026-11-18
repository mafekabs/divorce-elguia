package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findBySeekerIdOrderByAppointmentDateDesc(UUID seekerId);
    List<Appointment> findByOfficeId(UUID officeId);
    List<Appointment> findByOfficeName(String officeName);
    List<Appointment> findByOfficeIdAndAppointmentDate(UUID officeId, LocalDate date);
    List<Appointment> findByStatus(String status);
}
