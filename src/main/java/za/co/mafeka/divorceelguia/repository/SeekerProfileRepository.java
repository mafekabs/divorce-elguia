package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.SeekerProfile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeekerProfileRepository extends JpaRepository<SeekerProfile, UUID> {
    Optional<SeekerProfile> findByUserId(UUID userId);
    Optional<SeekerProfile> findByUserEmailAddress(String emailAddress);
    List<SeekerProfile> findByCity(String city);
    List<SeekerProfile> findByProvince(String province);
}
