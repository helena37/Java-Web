package bg.softuni.eshop.init;

import bg.softuni.eshop.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author helena81
 * @version 1.0
 * @since 9.08.21
 */
@Component
public class DataInit implements CommandLineRunner {
    private final ProductService productService;

    public DataInit(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
