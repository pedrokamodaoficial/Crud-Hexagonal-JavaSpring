package crudhexagonal.application.usecase;

import crudhexagonal.domain.repository.ProductRepository;

import java.util.UUID;

public class DeleteProductUseCase {

    private final ProductRepository productRepository;

    public DeleteProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(UUID id){

        if (productRepository.findById(id).isEmpty()){
            throw new RuntimeException("Produto não encontrado");
        }

        productRepository.deleteById(id);
    }
}
