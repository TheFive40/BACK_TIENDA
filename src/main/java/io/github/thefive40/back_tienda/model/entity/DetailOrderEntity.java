package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalles_Pedido")
public class DetailOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetail;

    @ManyToOne
    @JoinColumn(name = "idOrder_fk")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "idProduct_fk")
    private ProductEntity product;

    private int amount;

    private double unitPrice;

}
