package io.github.thefive40.back_tienda.model.dto;

import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.model.entity.ItemCartEntity;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCartDTO {
    private Long idCart;
    private ClientEntity client;
    private ProductEntity product;
    private List<ItemCartEntity> itemsCart = new ArrayList<> ();
    private Date startDate;

}
