package io.github.thefive40.back_tienda.mapper.clients;

import io.github.thefive40.back_tienda.model.dto.OrderDTO;
import io.github.thefive40.back_tienda.model.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CClientMapper.class, CDetailOrderMapper.class, CInvoicesMapper.class})
public interface COrderMapper {
    @Mappings ( {
            @Mapping ( target = "idClient",ignore = true)
    } )
    OrderDTO toDto( OrderEntity entity);
    @Mappings ( {
            @Mapping ( target = "idClient",ignore = true)
    } )
    OrderEntity toEntity( OrderDTO dto);
    List<OrderEntity> toEntityList(List<OrderDTO> orderDTOS);
    List<OrderDTO> toDtoList(List<OrderEntity> orderEntities);
}
