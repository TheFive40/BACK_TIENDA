package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ShoppingCartDTO;
import io.github.thefive40.back_tienda.model.entity.ShoppingCartEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ClientMapper.class, ItemCartMapper.class})
public interface ShoppingCartMapper {

    ShoppingCartDTO toDto( ShoppingCartEntity entity );

    ShoppingCartEntity toEntity( ShoppingCartDTO dto );

    List<ShoppingCartDTO> toListDto(List<ShoppingCartEntity> entities);
    
    List<ShoppingCartEntity> toListEntity(List<ShoppingCartDTO> dtos);
}
