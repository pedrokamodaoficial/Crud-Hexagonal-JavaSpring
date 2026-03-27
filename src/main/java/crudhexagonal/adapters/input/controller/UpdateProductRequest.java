package crudhexagonal.adapters.input.controller;

import java.math.BigDecimal;

public record UpdateProductRequest(
        String name,
        BigDecimal price
) {
}
