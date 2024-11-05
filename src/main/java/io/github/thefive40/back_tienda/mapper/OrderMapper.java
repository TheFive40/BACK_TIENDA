package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.OrderDTO;
import io.github.thefive40.back_tienda.model.entity.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, DetailOrderMapper.class, InvoicesMapper.class})
public interface OrderMapper {
    OrderDTO toDto( OrderEntity entity);
    OrderEntity toEntity( OrderDTO dto);
    List<OrderEntity> toEntityList(List<OrderDTO> orderDTOS);
    List<OrderDTO> toDtoList(List<OrderEntity> orderEntities);
}
