package bg.hristoskova.judge1.repository;

import bg.hristoskova.judge1.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author helena81
 * @version 1.0
 * @since 16.11.21
 */
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
    Optional<Exercise> findByName(String name);
}
