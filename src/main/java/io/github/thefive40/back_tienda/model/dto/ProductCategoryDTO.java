package io.github.thefive40.back_tienda.model.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductCategoryDTO {
    private long idProductCategory;
    private ProductDTO product;
    private CategoryDTO category;

}
