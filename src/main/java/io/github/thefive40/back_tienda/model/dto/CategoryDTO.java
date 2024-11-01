package io.github.thefive40.back_tienda.model.dto;

import io.github.thefive40.back_tienda.model.entity.ProductCategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long idCategory;
    private String name;
    private List<ProductCategoryDTO> productsCategory = new ArrayList<> ( );

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO(Long idCategory) {
        this.idCategory = idCategory;
    }
}

