package io.github.thefive40.back_tienda.model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailOrderDTO {
    private Long idDetail;
    private OrderDTO order;
    private ProductDTO product;
    private int amount;
    private double unitPrice;
}
