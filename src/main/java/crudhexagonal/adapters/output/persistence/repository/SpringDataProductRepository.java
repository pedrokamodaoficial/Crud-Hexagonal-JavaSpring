package crudhexagonal.adapters.output.persistence.repository;

import crudhexagonal.adapters.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, UUID> {
}
