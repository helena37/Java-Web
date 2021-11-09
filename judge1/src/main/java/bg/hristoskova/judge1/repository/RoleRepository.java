package bg.hristoskova.judge1.repository;

import bg.hristoskova.judge1.model.entity.Role;
import bg.hristoskova.judge1.model.service.RoleServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(String name);
}
