package io.github.thefive40.back_tienda.mapper.products;

import io.github.thefive40.back_tienda.mapper.clients.*;
import io.github.thefive40.back_tienda.model.dto.ProductDTO;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PClientMapper.class, CReviewMapper.class, CProductCategoryMapper.class, CDetailOrderMapper.class, CItemCartMapper.class,
CDetailInvoicesMapper.class})

public interface PProductMapper {

    ProductDTO toDto( ProductEntity entity);

    ProductEntity toEntity( ProductDTO dto);

    List<ProductEntity> toEntityList( List<ProductDTO> dtos);
    List<ProductDTO> toDtoList(List<ProductEntity> entities);
}
