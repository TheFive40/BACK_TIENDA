package io.github.thefive40.back_tienda.mapper.clients;

import io.github.thefive40.back_tienda.model.dto.DetailOrderDTO;
import io.github.thefive40.back_tienda.model.entity.DetailOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {COrderMapper.class, CProductMapper.class})
public interface CDetailOrderMapper {
    @Mappings({
            @Mapping(target = "order", ignore = true)
    })
    DetailOrderDTO toDto( DetailOrderEntity entity );
    @Mappings({
            @Mapping(target = "order", ignore = true)
    })
    DetailOrderEntity toEntity( DetailOrderDTO dto );
    List<DetailOrderDTO> toDtoList( List<DetailOrderEntity> entity );
    List<DetailOrderEntity> toEntityList( List<DetailOrderDTO> dto );
}
