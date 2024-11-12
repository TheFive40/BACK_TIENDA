package io.github.thefive40.back_tienda.mapper.shop;
import io.github.thefive40.back_tienda.model.dto.ShoppingCartDTO;
import io.github.thefive40.back_tienda.model.entity.ShoppingCartEntity;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring", uses = {SProductMapper.class, SClientMapper.class, SItemCartMapper.class})
public interface SShopingCartMapper {


    ShoppingCartDTO toDto( ShoppingCartEntity entity );

    ShoppingCartEntity toEntity( ShoppingCartDTO dto );

    List<ShoppingCartDTO> toListDto(List<ShoppingCartEntity> entities);
    
    List<ShoppingCartEntity> toListEntity(List<ShoppingCartDTO> dtos);
}
