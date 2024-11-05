package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ItemCartDTO;
import io.github.thefive40.back_tienda.model.entity.ItemCartEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ShoppingCartMapper.class, ProductMapper.class})
public interface ItemCartMapper {
    ItemCartDTO toDto( ItemCartEntity entity );
    ItemCartEntity toEntity( ItemCartDTO dto );
    List<ItemCartDTO> toListDto(List<ItemCartEntity> entities);
    List<ItemCartEntity> toListEntity(List<ItemCartDTO> dtos);
}
