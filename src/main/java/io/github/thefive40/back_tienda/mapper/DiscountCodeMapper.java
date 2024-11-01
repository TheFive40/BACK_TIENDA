package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.DiscountCodeDTO;
import io.github.thefive40.back_tienda.model.entity.DiscountCodeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountCodeMapper {
    DiscountCodeDTO toDto( DiscountCodeEntity entity );
    DiscountCodeEntity toEntity( DiscountCodeDTO dto );
}
