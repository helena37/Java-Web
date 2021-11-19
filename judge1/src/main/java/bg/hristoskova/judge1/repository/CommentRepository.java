package bg.hristoskova.judge1.repository;

import bg.hristoskova.judge1.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author helena81
 * @version 1.0
 * @since 19.11.21
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
}
