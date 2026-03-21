package crudhexagonal.adapters.output.persistence;

import crudhexagonal.adapters.output.persistence.mapper.ProductMapper;
import crudhexagonal.adapters.output.persistence.repository.SpringDataProductRepository;
import crudhexagonal.domain.model.Product;
import crudhexagonal.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final SpringDataProductRepository repository;

    public ProductRepositoryImpl(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        var entity = ProductMapper.toEntity(product);
        var saved = repository.save(entity);
        return ProductMapper.toDomain(saved);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll()
                .stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return repository.findById(id)
                .map(ProductMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
