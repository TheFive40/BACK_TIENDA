package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ProductCategoryDTO;
import io.github.thefive40.back_tienda.model.entity.ProductCategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, CategoryMapper.class})
public interface ProductCategoryMapper {
    ProductCategoryDTO toDto( ProductCategoryEntity productCategory );
    ProductCategoryEntity toEntity( ProductCategoryDTO productCategory );
}
