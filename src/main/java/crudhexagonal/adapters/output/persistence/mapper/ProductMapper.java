package crudhexagonal.adapters.output.persistence.mapper;

import crudhexagonal.adapters.output.persistence.entity.ProductEntity;
import crudhexagonal.domain.model.Product;

public class ProductMapper {

    public static ProductEntity toEntity(Product product){
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public static Product toDomain(ProductEntity entity){
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getPrice()
        );
    }
}
