package io.github.thefive40.back_tienda.model.dto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CategoryDTO {

    private long idCategory;
    private String name;
    private List<ProductCategoryDTO> productsCategory = new ArrayList<> ( );

}

