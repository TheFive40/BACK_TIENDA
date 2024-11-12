package io.github.thefive40.back_tienda.mapper.clients;

import io.github.thefive40.back_tienda.model.dto.ProductCategoryDTO;
import io.github.thefive40.back_tienda.model.entity.ProductCategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CProductMapper.class, CCategoryMapper.class})
public interface CProductCategoryMapper {
    ProductCategoryDTO toDto( ProductCategoryEntity entity );
    ProductCategoryEntity toEntity( ProductCategoryDTO dto );
    List<ProductCategoryEntity> toEntityList( List<ProductCategoryDTO> dtos);
    List<ProductCategoryDTO> toDtoList( List<ProductCategoryEntity> entities);
}
