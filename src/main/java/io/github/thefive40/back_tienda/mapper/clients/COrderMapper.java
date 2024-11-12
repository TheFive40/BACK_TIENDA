package io.github.thefive40.back_tienda.mapper.clients;

import io.github.thefive40.back_tienda.model.dto.OrderDTO;
import io.github.thefive40.back_tienda.model.entity.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CClientMapper.class, CDetailOrderMapper.class, CInvoicesMapper.class})
public interface COrderMapper {
    OrderDTO toDto( OrderEntity entity);
    OrderEntity toEntity( OrderDTO dto);
    List<OrderEntity> toEntityList(List<OrderDTO> orderDTOS);
    List<OrderDTO> toDtoList(List<OrderEntity> orderEntities);
}
