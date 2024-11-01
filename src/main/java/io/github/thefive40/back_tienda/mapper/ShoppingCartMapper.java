package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ShoppingCartDTO;
import io.github.thefive40.back_tienda.model.entity.ShoppingCartEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, ProductMapper.class, ItemCartMapper.class})

public interface ShoppingCartMapper {
    ShoppingCartDTO toDto ( ShoppingCartEntity shoppingCartEntity );

    ShoppingCartEntity toEntity ( ShoppingCartDTO shoppingCartDto );
}
