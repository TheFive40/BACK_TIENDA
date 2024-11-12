package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCart;

    @ManyToOne
    @JoinColumn(name = "id_cart_fk")
    private ShoppingCartEntity shoppingCart;
    @ManyToOne
    @JoinColumn(name = "id_product_fk")
    private ProductEntity product;

    private int quantity;
}
