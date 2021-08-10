package bg.softuni.eshop.domain.entity;

import bg.softuni.eshop.domain.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.EnumType.*;

/**
 * @author helena81
 * @version 1.0
 * @since 7/8/2021
 */

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private String gender;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, String category, String gender) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.gender = gender;
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "gender", nullable = false)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
