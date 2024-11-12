package io.github.thefive40.back_tienda.mapper.shop;
import io.github.thefive40.back_tienda.model.dto.ItemCartDTO;
import io.github.thefive40.back_tienda.model.entity.ItemCartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring", uses = {SShopingCartMapper.class, SProductMapper.class})
public interface SItemCartMapper {
    @Mappings( {
            @Mapping( target = "shoppingCart",ignore = true)
    } )
    ItemCartDTO toDto( ItemCartEntity entity );
    @Mappings( {
            @Mapping( target = "shoppingCart",ignore = true)
    } )
    ItemCartEntity toEntity( ItemCartDTO dto );
    List<ItemCartDTO> toListDto( List<ItemCartEntity> entities);
    List<ItemCartEntity> toListEntity(List<ItemCartDTO> dtos);
}
