package com.annahita.bootshop.mapper;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.annahita.bootshop.dto.ProductDto;
import com.annahita.bootshop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto productDto);
    Product infoDtoToEntity(ProductDto.Info productDtoInfo);
    Product createDtoToEntity(ProductDto.Create productDtoCreate);

    @Mapping(target = "productId", ignore = true) // جلوگیری از تغییر id
    @Mapping(target = "productCategory", ignore = true) // جلوگیری از تغییر productCategory
    void updateEntity(ProductDto.Update updateDto, @MappingTarget Product product);

    ProductDto.Info toDtoInfo(Product product);
    List<ProductDto.Info> toDtoInfoList(List<Product> products);
    ProductDto toDto(Product product);
}
