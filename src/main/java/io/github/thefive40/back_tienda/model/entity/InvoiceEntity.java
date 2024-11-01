package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Factura")
@Getter
@Setter
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInvoice;

    private int nroInvoice;
    @ManyToOne
    @JoinColumn(name = "idPedido_fk")
    private OrderEntity order;

    private Date startDate;

    private double subTotal;

    private double tax;

    private double discount;

    private double total;
}
