package io.github.thefive40.back_tienda.model.dto;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InvoiceDTO {
    private long idInvoice;

    private int nroInvoice;

    private Date startDate;

    private double subTotal;

    private double tax;

    private double discount;

    private double total;

    private boolean status;

    private ClientEntity client;

    private List<DetailInvoiceDTO> detailsInvoice = new ArrayList<> (  );

}
