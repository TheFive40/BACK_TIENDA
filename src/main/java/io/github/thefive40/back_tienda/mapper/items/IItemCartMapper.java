package io.github.thefive40.back_tienda.mapper.items;
import io.github.thefive40.back_tienda.mapper.shop.SProductMapper;
import io.github.thefive40.back_tienda.model.dto.ItemCartDTO;
import io.github.thefive40.back_tienda.model.entity.ItemCartEntity;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring", uses = {IShoppingCartMapper.class, SProductMapper.class})

public interface IItemCartMapper {
    ItemCartDTO toDto( ItemCartEntity entity );
    ItemCartEntity toEntity( ItemCartDTO dto );
    List<ItemCartDTO> toListDto( List<ItemCartEntity> entities);
    List<ItemCartEntity> toListEntity(List<ItemCartDTO> dtos);
}
