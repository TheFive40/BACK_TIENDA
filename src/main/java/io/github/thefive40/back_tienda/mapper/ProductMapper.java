package io.github.thefive40.back_tienda.mapper;
import io.github.thefive40.back_tienda.model.dto.ProductDTO;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class,ReviewMapper.class, ProductCategoryMapper.class
, DetailOrderMapper.class, ItemCartMapper.class})
public interface ProductMapper {

    ProductDTO toDto( ProductEntity productEntity );

    ProductEntity toEntity(ProductEntity productEntity);
}
