package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "public_holidays")
public class PublicHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer year;

    @Column(name = "holiday_date")
    private LocalDate holidayDate;

    private String name; // 16 June Youth Day
}
