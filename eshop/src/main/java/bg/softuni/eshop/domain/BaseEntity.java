package bg.softuni.eshop.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author helena81
 * @version 1.0
 * @since 7/8/2021
 */

@MappedSuperclass
public abstract class BaseEntity {
    private String UUID;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
