package io.github.thefive40.back_tienda.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemCartDTO {
    private long idCart;
    private ShoppingCartDTO shoppingCart;
    private ProductDTO product;

}
