package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;

@Entity
public class ItemCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCart;

    @ManyToOne
    @JoinColumn(name = "id_cart_fk")
    private ShoppingCartEntity shoppingCart;
    @ManyToOne
    @JoinColumn(name = "id_product_fk")
    private ProductEntity product;
}
