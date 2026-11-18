package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.co.mafeka.divorceelguia.model.Office;

import java.util.List;
import java.util.UUID;

public interface OfficeRepository extends JpaRepository<Office, UUID> {
    List<Office> findByIsActiveTrue();
    List<Office> findByIsActiveTrueOrderByNameAsc();
    List<Office> findByCityIgnoreCase(String city);
    List<Office> findByProvinceIgnoreCase(String province);
    List<Office> findByCityIgnoreCaseAndIsActiveTrue(String city);
    List<Office> findByProvinceIgnoreCaseAndIsActiveTrue(String province);

    // Find offices that offer a specific service
    @Query("SELECT o FROM Office o JOIN o.legalServices s WHERE s.id = :serviceId AND o.isActive = true")
    List<Office> findActiveByServiceId(@Param("serviceId") UUID serviceId);

    // Find offices that offer ALL legalServices in list
    @Query("SELECT o FROM Office o JOIN o.legalServices s WHERE s.id IN :serviceIds AND o.isActive = true GROUP BY o HAVING COUNT(DISTINCT s.id) = :count")
    List<Office> findActiveByAllServiceIds(@Param("serviceIds") List<UUID> serviceIds, @Param("count") long count);
}
