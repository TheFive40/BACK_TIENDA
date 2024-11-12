package io.github.thefive40.back_tienda.mapper.clients;

import io.github.thefive40.back_tienda.model.dto.ShoppingCartDTO;
import io.github.thefive40.back_tienda.model.entity.ShoppingCartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring", uses = {CProductMapper.class, CClientMapper.class, CItemCartMapper.class})
public interface CShoppingCartMapper {
    @Mapping ( target = "client", ignore = true)
    ShoppingCartDTO toDto( ShoppingCartEntity entity );
    @Mapping ( target = "client", ignore = true)
    ShoppingCartEntity toEntity( ShoppingCartDTO dto );

    List<ShoppingCartDTO> toListDto( List<ShoppingCartEntity> entities);

    List<ShoppingCartEntity> toListEntity(List<ShoppingCartDTO> dtos);
}
