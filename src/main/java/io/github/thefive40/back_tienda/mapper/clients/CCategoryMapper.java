package io.github.thefive40.back_tienda.mapper.clients;

import io.github.thefive40.back_tienda.model.dto.CategoryDTO;
import io.github.thefive40.back_tienda.model.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CProductCategoryMapper.class})
public interface CCategoryMapper {

    CategoryDTO toDto( CategoryEntity entity );

    CategoryEntity toEntity( CategoryDTO dto);

    List<CategoryDTO> toDtoList(List<CategoryEntity> entities);

    List<CategoryEntity> toEntityList(List<CategoryDTO> dtos);
}
