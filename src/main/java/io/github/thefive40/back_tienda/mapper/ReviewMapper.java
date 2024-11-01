package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ReviewDTO;
import io.github.thefive40.back_tienda.model.entity.ReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ClientMapper.class})

public interface ReviewMapper {
    ReviewDTO toDto( ReviewEntity reviewEntity );
    ReviewEntity toEntity( ReviewDTO reviewDTO );
}
