package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Reseñas")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReview;

    @ManyToOne(targetEntity = ProductEntity.class)
    @JoinColumn(name = "idproduct_fk")
    private ProductEntity product;
    @ManyToOne(targetEntity = ClientEntity.class)
    @JoinColumn(name = "idclient_fk")
    private ClientEntity idClient;

}
