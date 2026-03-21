package crudhexagonal;

import crudhexagonal.adapters.output.persistence.ProductRepositoryImpl;
import crudhexagonal.adapters.output.persistence.repository.SpringDataProductRepository;
import crudhexagonal.application.usecase.CreateProductUseCase;
import crudhexagonal.domain.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class TestRunner {

    @Bean
    CommandLineRunner run(SpringDataProductRepository springRepo) {
        return args -> {

            ProductRepository productRepository = new ProductRepositoryImpl(springRepo);

            CreateProductUseCase createProduct = new CreateProductUseCase(productRepository);

            var product = createProduct.execute("Mouse Gamer", new BigDecimal("150.00"));

            System.out.println("Produto criado: " + product.getName());

        };
    }
}
