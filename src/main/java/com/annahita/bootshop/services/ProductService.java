package com.annahita.bootshop.services;

import com.annahita.bootshop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto.Info create(ProductDto.Create productDtoCreate);
    ProductDto.Info update(Long productId, ProductDto.Update productDtoUpdate);
    void delete(Long id);
    ProductDto.Info getProductById(Long productId);
    List<ProductDto.Info> getProducts();
}
