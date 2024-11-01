package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ProductoCategoria")
@Getter
@Setter
public class ProductCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long idProductCategory;
    @ManyToOne
    @JoinColumn(name = "idProduct_fk")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "idCategory_fk")
    private CategoryEntity category;
}
