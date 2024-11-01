package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Reseñas")
@Getter
@Setter
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idReview;

    @ManyToOne(targetEntity = ProductEntity.class)
    @JoinColumn(name = "idproduct_fk")
    private ProductEntity product;
    @ManyToOne(targetEntity = ClientEntity.class)
    @JoinColumn(name = "idclient_fk")
    private ClientEntity idClient;

}
