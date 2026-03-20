package crudhexagonal.application.usecase;

import crudhexagonal.domain.model.Product;
import crudhexagonal.domain.repository.ProductRepository;

import java.util.List;

public class ListProductsUseCase {

    private final ProductRepository productRepository;

    public ListProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> execute(){
        return productRepository.findAll();
    }
}
