package crudhexagonal.configs;

import crudhexagonal.application.usecase.*;
import crudhexagonal.domain.repository.ProductRepository;
import crudhexagonal.domain.repository.UserRepository;
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

    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }

    @Bean
    public LoginUseCase loginUseCase(UserRepository userRepository, JwtService jwtService) {
        return new LoginUseCase(userRepository, jwtService);
    }
}
