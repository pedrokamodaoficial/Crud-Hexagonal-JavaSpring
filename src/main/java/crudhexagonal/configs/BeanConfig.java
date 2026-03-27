package crudhexagonal.configs;

import crudhexagonal.application.usecase.CreateProductUseCase;
import crudhexagonal.application.usecase.DeleteProductUseCase;
import crudhexagonal.application.usecase.ListProductsUseCase;
import crudhexagonal.application.usecase.UpdateProductUseCase;
import crudhexagonal.domain.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository repository){
        return new CreateProductUseCase(repository);
    }

    @Bean
    public ListProductsUseCase listProductsUseCase(ProductRepository repository) {
        return new ListProductsUseCase(repository);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductRepository repository){
        return new UpdateProductUseCase(repository);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductRepository repository){
        return new DeleteProductUseCase(repository);
    }
}
