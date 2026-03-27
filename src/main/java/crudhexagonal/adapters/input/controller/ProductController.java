package crudhexagonal.adapters.input.controller;


import crudhexagonal.application.usecase.CreateProductUseCase;
import crudhexagonal.application.usecase.DeleteProductUseCase;
import crudhexagonal.application.usecase.ListProductsUseCase;
import crudhexagonal.application.usecase.UpdateProductUseCase;
import crudhexagonal.domain.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Anotação para definir a classe com métodos HTTP
@RequestMapping("/products") //Anotação para definir a rota
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, ListProductsUseCase listProductsUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.listProductsUseCase = listProductsUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @PostMapping //Cria o produto
    public Product create(@RequestBody CreateProductRequest request){ //Converte JSON para objeto Java
        return createProductUseCase.execute(
                request.name(),
                request.price()
        );
    }

    @PutMapping("/{id}") //Define a rota para atualização do produto através de seu ID
    public Product update(@PathVariable String id,
                          @RequestBody UpdateProductRequest request){

        return updateProductUseCase.execute(
                java.util.UUID.fromString(id),
                request.name(),
                request.price()
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){

        deleteProductUseCase.execute(
                java.util.UUID.fromString(id)
        );
    }

    @GetMapping
    public List<Product> list(){
        return listProductsUseCase.execute();
    }
}
