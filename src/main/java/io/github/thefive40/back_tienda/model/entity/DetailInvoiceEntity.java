package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detalle_Facturas")
@Getter
@Setter
public class DetailInvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_invoice_fk")
    private InvoiceEntity invoice;

    @ManyToOne
    @JoinColumn
    private ProductEntity product;

    private int quantity;

    private double unitPrice;
}
