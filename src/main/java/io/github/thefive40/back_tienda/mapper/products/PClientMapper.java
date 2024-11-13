package io.github.thefive40.back_tienda.mapper.products;
import io.github.thefive40.back_tienda.mapper.clients.COrderMapper;
import io.github.thefive40.back_tienda.mapper.clients.CShoppingCartMapper;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring", uses = {PProductMapper.class, CShoppingCartMapper.class,  COrderMapper.class})
public interface PClientMapper {
    @Mappings({
            @Mapping(target = "products", ignore = true),
    })
    ClientDTO toDto(ClientEntity entity);

    @Mappings({
            @Mapping(target = "products", ignore = true),
    })
    ClientEntity toEntity(ClientDTO dto);

    List<ClientDTO> toDtoList(List<ClientEntity> entities);
    List<ClientEntity> toEntityList(List<ClientDTO> dtos);
}
