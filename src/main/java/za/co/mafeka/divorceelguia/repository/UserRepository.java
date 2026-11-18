package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailAddress(String emailAddress);
    Optional<User> findByUserName(String userName);
    boolean existsByEmailAddress(String emailAddress);
    boolean existsByUserName(String userName);
}
