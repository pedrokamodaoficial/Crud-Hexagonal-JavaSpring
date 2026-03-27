package crudhexagonal.application.usecase;

import crudhexagonal.domain.model.Product;
import crudhexagonal.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class UpdateProductUseCase {

    private final ProductRepository productRepository;

    public UpdateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(UUID id, String name, BigDecimal price){
        //Buscar produto
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        //Atualizar os dados
        product.updateName(name);
        product.setPrice(price);

        //Salvar atualização
        return productRepository.save(product);
    }
}
