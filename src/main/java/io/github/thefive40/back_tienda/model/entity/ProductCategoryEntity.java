package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductoCategoria")
public class ProductCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idProductCategory;
    @ManyToOne
    @JoinColumn(name = "idProduct_fk")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "idCategory_fk")
    private CategoryEntity category;
}
