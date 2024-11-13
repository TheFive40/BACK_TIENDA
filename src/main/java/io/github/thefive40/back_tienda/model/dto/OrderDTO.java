package io.github.thefive40.back_tienda.model.dto;
import io.github.thefive40.back_tienda.model.entity.InvoiceEntity;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderDTO {
    private long idOrder;
    private double total;
    private Date orderDate;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    private String paymentMethod;
    private String discountCode;
    private ClientDTO idClient;
    private List<DetailOrderDTO> detailOrder = new ArrayList<> ( );
    private List<InvoiceEntity> invoices = new ArrayList<> (  );

    @Override
    public boolean equals ( Object object ) {
        if (this == object) return true;
        if (!(object instanceof OrderDTO orderDTO)) return false;
        return getIdOrder ( ) == orderDTO.getIdOrder ( );
    }

    @Override
    public int hashCode () {
        return Objects.hashCode ( getIdOrder ( ) );
    }
}
