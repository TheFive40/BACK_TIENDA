package io.github.thefive40.back_tienda.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShoppingCartDTO {
    private long idCart;
    private ClientDTO client;
    private List<ItemCartDTO> itemsCart = new ArrayList<> ();
    private Date startDate;

}
