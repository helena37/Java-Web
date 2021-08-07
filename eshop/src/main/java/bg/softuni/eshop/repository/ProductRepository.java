package bg.softuni.eshop.repository;

import bg.softuni.eshop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author helena81
 * @version 1.0
 * @since 7.08.21
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
