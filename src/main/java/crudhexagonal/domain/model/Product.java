package crudhexagonal.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID id;
    private String name;
    private BigDecimal price;

    public Product(UUID id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.name = name;
        setPrice(price);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void updateName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Nome inválido");
        }
        this.name = name;
    }

    public void setPrice(BigDecimal price){
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        this.price = price;
    }
}
