package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ItemCartDTO;
import io.github.thefive40.back_tienda.model.entity.ItemCartEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ShoppingCartMapper.class, ProductMapper.class})
public interface ItemCartMapper {
    ItemCartDTO toDto( ItemCartEntity itemCartEntity );
    ItemCartEntity toEntity(ItemCartDTO itemCartDTO);
}
