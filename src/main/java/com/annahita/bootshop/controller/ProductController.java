package com.annahita.bootshop.controller;

import com.annahita.bootshop.dto.ProductDto;
import com.annahita.bootshop.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> create(@Valid @ModelAttribute ProductDto.Create productDtoCreate) {
        try {
            ProductDto.Info createdProduct = productService.create(productDtoCreate);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create product: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{productId}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> update(@PathVariable Long productId, @Valid @ModelAttribute ProductDto.Update productDtoUpdate) {
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

    @GetMapping("/{productId}/image")
    public ResponseEntity<?> getProductImage(@PathVariable Long productId) {
        try {
            byte[] image = productService.getProductImage(productId);
            if (image == null || image.length == 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found for product ID: " + productId);
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(image);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
