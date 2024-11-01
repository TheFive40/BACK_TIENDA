package io.github.thefive40.back_tienda.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProductCategoryMapper.class)
public interface CategoryMapper {
}
