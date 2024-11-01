package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.OrderDTO;
import io.github.thefive40.back_tienda.model.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DetailOrderMapper.class, ClientMapper.class})
public interface OrderMapper {
    OrderDTO toDto( OrderEntity orderEntity);
    OrderEntity toEntity(OrderDTO orderDTO);
}
