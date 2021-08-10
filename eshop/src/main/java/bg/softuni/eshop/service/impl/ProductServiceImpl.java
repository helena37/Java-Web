package bg.softuni.eshop.service.impl;

import bg.softuni.eshop.repository.ProductRepository;
import bg.softuni.eshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author helena81
 * @version 1.0
 * @since 9.08.21
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
}
