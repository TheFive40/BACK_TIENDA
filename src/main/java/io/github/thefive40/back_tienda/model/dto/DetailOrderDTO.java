package io.github.thefive40.back_tienda.model.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DetailOrderDTO {
    private long idDetail;
    private OrderDTO order;
    private ProductDTO product;
    private int amount;
    private double unitPrice;
}
