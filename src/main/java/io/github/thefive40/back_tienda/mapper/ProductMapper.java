package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ProductDTO;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ClientMapper.class, ReviewMapper.class, ProductCategoryMapper.class, DetailOrderMapper.class, ItemCartMapper.class })
public interface ProductMapper {

    ProductDTO toDto( ProductEntity entity);

    ProductEntity toEntity( ProductDTO dto);

    List<ProductDTO> toDtoList( List<ProductEntity> entities);

    List<ProductEntity> toEntityList(List<ProductDTO> dtos);
}
