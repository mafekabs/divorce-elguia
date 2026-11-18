package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.PublicHoliday;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PublicHolidayRepository extends JpaRepository<PublicHoliday, UUID> {
    List<PublicHoliday> findByHolidayDateBetween(LocalDate start, LocalDate end);
    List<PublicHoliday> findByHolidayDate(LocalDate date);
    boolean existsByHolidayDate(LocalDate date);
    List<PublicHoliday> findByYearOrderByHolidayDateAsc(int year);
}