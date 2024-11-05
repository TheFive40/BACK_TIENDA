package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ReviewDTO;
import io.github.thefive40.back_tienda.model.entity.ReviewEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, ProductMapper.class})
public interface ReviewMapper {
    ReviewDTO toDto( ReviewEntity entity );
    ReviewEntity toEntity( ReviewDTO dto );
    List<ReviewDTO> toDtoList(List<ReviewEntity> entities );
    List<ReviewEntity> toEntityList(List<ReviewDTO> dtos );
}
