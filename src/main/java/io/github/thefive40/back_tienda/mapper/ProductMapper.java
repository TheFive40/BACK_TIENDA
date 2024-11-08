package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ProductDTO;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ClientMapper.class, ReviewMapper.class, ProductCategoryMapper.class, DetailOrderMapper.class, ItemCartMapper.class })
public interface ProductMapper {

    @Mappings (
            {
                    @Mapping ( target = "client", ignore = true)
            }
    )
    ProductDTO toDto( ProductEntity entity);
    @Mappings (
            {
                    @Mapping ( target = "client", ignore = true)
            }
    )
    ProductEntity toEntity( ProductDTO dto);

    List<ProductEntity> toEntityList(List<ProductDTO> dtos);
    List<ProductDTO> toDtoList(List<ProductEntity> entities);
}
