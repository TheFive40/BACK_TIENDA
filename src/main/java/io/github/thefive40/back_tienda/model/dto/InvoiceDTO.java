package io.github.thefive40.back_tienda.model.dto;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals ( Object object ) {
        if (this == object) return true;
        if (!(object instanceof InvoiceDTO that)) return false;
        return getNroInvoice ( ) == that.getNroInvoice ( );
    }

    @Override
    public int hashCode () {
        return Objects.hashCode ( getNroInvoice ( ) );
    }
}
