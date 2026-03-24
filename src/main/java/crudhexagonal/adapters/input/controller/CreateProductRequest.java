package crudhexagonal.adapters.input.controller;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        BigDecimal price
) {
}
