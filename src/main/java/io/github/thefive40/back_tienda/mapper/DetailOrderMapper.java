package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.DetailOrderDTO;
import io.github.thefive40.back_tienda.model.entity.DetailOrderEntity;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {ProductMapper.class, OrderMapper.class})
public interface DetailOrderMapper {
    DetailOrderDTO toDto ( DetailOrderEntity entity );
    DetailOrderEntity toEntity ( DetailOrderDTO dto );
}
