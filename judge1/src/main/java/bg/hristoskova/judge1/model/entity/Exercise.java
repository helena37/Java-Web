package bg.hristoskova.judge1.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author helena81
 * @version 1.0
 * @since 8.11.21
 */

@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity {
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    public Exercise() {
    }

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "started_on", nullable = false)
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    @Column(name = "due_date", nullable = false)
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
