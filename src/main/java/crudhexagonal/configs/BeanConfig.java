package crudhexagonal.configs;

import crudhexagonal.application.usecase.CreateProductUseCase;
import crudhexagonal.application.usecase.ListProductsUseCase;
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
}
