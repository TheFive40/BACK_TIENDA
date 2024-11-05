package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ProductCategoryDTO;
import io.github.thefive40.back_tienda.model.entity.ProductCategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, CategoryMapper.class})
public interface ProductCategoryMapper {
    ProductCategoryDTO toDto( ProductCategoryEntity entity );
    ProductCategoryEntity toEntity( ProductCategoryDTO dto );
    List<ProductCategoryEntity> toEntityList( List<ProductCategoryDTO> dtos);
    List<ProductCategoryDTO> toDtoList( List<ProductCategoryEntity> entities);
}
