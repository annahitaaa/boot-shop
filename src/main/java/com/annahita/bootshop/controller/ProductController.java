package com.annahita.bootshop.controller;

import com.annahita.bootshop.dto.ProductDto;
import com.annahita.bootshop.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private  ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto.Info>> getAllProducts() {
        List<ProductDto.Info> products = productService.getProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId) {
        try {

            return ResponseEntity.ok(productService.getProductById(productId));
        }catch (Exception e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<ProductDto.Info> create(@Valid @RequestBody ProductDto.Create productDtoCreate) {
        ProductDto.Info createdProduct = productService.create(productDtoCreate);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("{productId}")
    public ResponseEntity<?> update(@PathVariable Long productId, @Valid @RequestBody ProductDto.Update productDtoUpdate) {
        try {
            ProductDto.Info updatedProduct = productService.update(productId, productDtoUpdate);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(ProductDto.Delete productDtoDelete) {

        try{
            productService.delete(productDtoDelete.getProductId());

            return ResponseEntity.ok("product Deleted successfully");
        }catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
