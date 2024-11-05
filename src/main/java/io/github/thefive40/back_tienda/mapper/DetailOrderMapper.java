package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.DetailOrderDTO;
import io.github.thefive40.back_tienda.model.entity.DetailOrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderMapper.class, ProductMapper.class})
public interface DetailOrderMapper {
    DetailOrderDTO toDto( DetailOrderEntity entity );
    DetailOrderEntity toEntity( DetailOrderDTO dto );
    List<DetailOrderDTO> toDtoList( List<DetailOrderEntity> entity );
    List<DetailOrderEntity> toEntityList( List<DetailOrderDTO> dto );
}
