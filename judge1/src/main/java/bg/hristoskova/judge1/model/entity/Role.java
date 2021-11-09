package bg.hristoskova.judge1.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author helena81
 * @version 1.0
 * @since 8.11.21
 */

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private String name;

    public Role() {
    }

    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
