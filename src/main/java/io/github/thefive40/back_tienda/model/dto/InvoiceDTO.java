package io.github.thefive40.back_tienda.model.dto;

import io.github.thefive40.back_tienda.model.entity.OrderEntity;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvoiceDTO {
    private Long idInvoice;

    private int nroInvoice;

    private OrderEntity order;

    private Date startDate;

    private double subTotal;

    private double tax;

    private double discount;

    private double total;
}
