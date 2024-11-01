package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Carrito")
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCart;
    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private ClientEntity client;
    @ManyToOne
    @JoinColumn(name = "id_product_fk")
    private ProductEntity product;
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<ItemCartEntity> itemsCart = new ArrayList<>();
    private Date startDate;
}
