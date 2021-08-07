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
    private Category category;
    private Gender gender;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, Category category, Gender gender) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.gender = gender;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
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

    @Enumerated(STRING)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Enumerated(STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
