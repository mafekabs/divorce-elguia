package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerProfile seeker;

    @Column(name="date_time")
    private LocalDateTime appointmentDate;

    private String notes;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status = AppointmentStatus.REQUESTED;
}