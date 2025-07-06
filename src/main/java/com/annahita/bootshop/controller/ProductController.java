package com.annahita.bootshop.controller;

import com.annahita.bootshop.dto.ProductDto;
import com.annahita.bootshop.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto.Info>> getAllProducts() {
        List<ProductDto.Info> products = productService.getProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto.Info> getProductById(@PathVariable Long productId) {

        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductDto.Info> create(@Valid @ModelAttribute ProductDto.Create productDtoCreate) {
        ProductDto.Info createdProduct = productService.create(productDtoCreate);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{productId}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductDto.Info> update(@PathVariable Long productId, @Valid @ModelAttribute ProductDto.Update productDtoUpdate) {
        ProductDto.Info updatedProduct = productService.update(productId, productDtoUpdate);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(ProductDto.Delete productDtoDelete) {
        productService.delete(productDtoDelete.getProductId());

        return ResponseEntity.ok("Product deleted successfully");

    }

    @GetMapping("/{productId}/image")
    public ResponseEntity<?> getProductImage(@PathVariable Long productId) {
        byte[] image = productService.getProductImage(productId);
        if (image == null || image.length == 0) {
            throw new EntityNotFoundException("Image not found for product ID: " + productId);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }

   /* @PostMapping(value = "/{productId}/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadProductImage(@PathVariable Long productId, @RequestPart("image") MultipartFile image) {
        productService.uploadProductImage(productId, image);
        return ResponseEntity.ok("Image uploaded successfully for product ID: " + productId);
    }*/
}
