package crudhexagonal.adapters.input.controller;


import crudhexagonal.application.usecase.CreateProductUseCase;
import crudhexagonal.application.usecase.ListProductsUseCase;
import crudhexagonal.domain.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Anotação para definir a classe com métodos HTTP
@RequestMapping("/products") //Anotação para definir a rota
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ListProductsUseCase listProductsUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, ListProductsUseCase listProductsUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.listProductsUseCase = listProductsUseCase;
    }

    @PostMapping //Cria o produto
    public Product create(@RequestBody CreateProductRequest request){ //Converte JSON para objeto Java
        return createProductUseCase.execute(
                request.name(),
                request.price()
        );
    }

    @GetMapping
    public List<Product> list(){
        return listProductsUseCase.execute();
    }
}
