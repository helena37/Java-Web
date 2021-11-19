package bg.hristoskova.judge1.repository;

import bg.hristoskova.judge1.model.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
@Repository
public interface HomeworkRepository extends JpaRepository<Homework, String> {

}
