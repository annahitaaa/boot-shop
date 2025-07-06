package com.annahita.bootshop.services.impl;

import com.annahita.bootshop.dto.ProductDto;
import com.annahita.bootshop.entity.Product;
import com.annahita.bootshop.mapper.ProductMapper;
import com.annahita.bootshop.repository.ProductRepository;
import com.annahita.bootshop.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    @Transactional
    public ProductDto.Info create(ProductDto.Create productDtoCreate) {
        Product product = productMapper.createDtoToEntity(productDtoCreate);
        Product savedProduct = productRepository.save(product);

        return productMapper.toDtoInfo(savedProduct);
    }

    @Override
    @Transactional
    public ProductDto.Info update(Long productId, ProductDto.Update productDtoUpdate) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        productMapper.updateEntity(productDtoUpdate, product);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDtoInfo(updatedProduct);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto.Info getProductById(Long productId) {
        Optional<Product>  optionalProduct = productRepository.findById(productId);
        return productMapper.toDtoInfo(optionalProduct.orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId)));

    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto.Info> getProducts() {
        return productMapper.toDtoInfoList(productRepository.findAll());
    }

    @Override
    public byte[] getProductImage(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        return product.getImg();
    }
}
