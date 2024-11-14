package io.github.thefive40.back_tienda.mapper.shop;

import io.github.thefive40.back_tienda.mapper.clients.COrderMapper;
import io.github.thefive40.back_tienda.mapper.clients.CProductMapper;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CProductMapper.class, SShopingCartMapper.class, COrderMapper.class})

public interface SClientMapper {
    @Mappings({
            @Mapping(target = "shoppingCart", ignore = true)
    })
    ClientDTO toDto ( ClientEntity entity );
    @Mappings({
            @Mapping(target = "shoppingCart", ignore = true)
    })
    ClientEntity toEntity ( ClientDTO dto );

    List<ClientDTO> toDtoList ( List<ClientEntity> entities );

    List<ClientEntity> toEntityList ( List<ClientDTO> dtos );
}
