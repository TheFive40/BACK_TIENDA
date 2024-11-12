package io.github.thefive40.back_tienda.mapper.items;

import io.github.thefive40.back_tienda.mapper.shop.SClientMapper;
import io.github.thefive40.back_tienda.mapper.shop.SItemCartMapper;
import io.github.thefive40.back_tienda.mapper.shop.SProductMapper;
import io.github.thefive40.back_tienda.model.dto.ShoppingCartDTO;
import io.github.thefive40.back_tienda.model.entity.ShoppingCartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring", uses = {SProductMapper.class, SClientMapper.class, SItemCartMapper.class})

public interface IShoppingCartMapper {
    @Mappings ( {
            @Mapping ( target = "itemsCart",ignore = true)
    } )
    ShoppingCartDTO toDto( ShoppingCartEntity entity );
    @Mappings ( {
            @Mapping ( target = "itemsCart",ignore = true)
    } )
    ShoppingCartEntity toEntity( ShoppingCartDTO dto );

    List<ShoppingCartDTO> toListDto( List<ShoppingCartEntity> entities);

    List<ShoppingCartEntity> toListEntity(List<ShoppingCartDTO> dtos);
}
