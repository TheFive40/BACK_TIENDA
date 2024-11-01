package io.github.thefive40.back_tienda.model.dto;

import io.github.thefive40.back_tienda.model.entity.CategoryEntity;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDTO {
    private Long idProductCategory;
    private ProductEntity product;
    private CategoryEntity category;

}
