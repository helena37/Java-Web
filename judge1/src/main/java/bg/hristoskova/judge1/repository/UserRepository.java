package bg.hristoskova.judge1.repository;

import bg.hristoskova.judge1.model.entity.User;
import bg.hristoskova.judge1.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
