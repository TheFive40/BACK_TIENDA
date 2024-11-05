package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detalles_Pedido")
@Getter
@Setter
public class DetailOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetail;

    @ManyToOne
    @JoinColumn(name = "idOrder_fk")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "idProduct_fk")
    private ProductEntity product;

    private int amount;

    private double unitPrice;

}
