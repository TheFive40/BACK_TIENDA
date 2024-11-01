package io.github.thefive40.back_tienda.model.dto;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class InvoiceDTO {
    private long idInvoice;

    private int nroInvoice;

    private OrderDTO order;

    private Date startDate;

    private double subTotal;

    private double tax;

    private double discount;

    private double total;
}
