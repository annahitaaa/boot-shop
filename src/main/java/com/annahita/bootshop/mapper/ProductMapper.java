package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.ProductDto;
import com.annahita.bootshop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    Product toEntity(ProductDto productDto);
    Product infoDtoToEntity(ProductDto.Info productDtoInfo);

    @Mapping(target = "img", source = "image", qualifiedByName = "multipartFileToByteArray")
    Product createDtoToEntity(ProductDto.Create productDtoCreate);

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "productCategory", ignore = true)
    @Mapping(target = "img", source = "image", qualifiedByName = "multipartFileToByteArray")
    void updateEntity(ProductDto.Update updateDto, @MappingTarget Product product);

    @Mapping(target = "image", source = "img")
    ProductDto.Info toDtoInfo(Product product);
    List<ProductDto.Info> toDtoInfoList(List<Product> products);
    ProductDto toDto(Product product);


    @org.mapstruct.Named("multipartFileToByteArray")
    default byte[] multipartFileToByteArray(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }
        return file.getBytes();
    }
}
