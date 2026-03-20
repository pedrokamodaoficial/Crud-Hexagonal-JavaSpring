package crudhexagonal.application.usecase;

import crudhexagonal.domain.model.Product;
import crudhexagonal.domain.repository.ProductRepository;

import java.math.BigDecimal;

public class CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(String name, BigDecimal price){

        Product product = new Product(name, price);

        return productRepository.save(product);
    }
}
