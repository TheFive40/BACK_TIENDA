package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String name;

    private String description;

    private double price;

    private String img;

    private Date dateRegistration;

    @ManyToOne
    @JoinColumn(name = "idClient_fk", nullable = false)
    private ClientEntity client;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviews = new ArrayList<> ( );
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCategoryEntity> productsCategory = new ArrayList<> ( );
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailOrderEntity> detailsOrder = new ArrayList<> ( );
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCartEntity> itemsCart = new ArrayList<>();
    public ProductEntity ( Long productId, String name, String description, double price, String img ) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.dateRegistration = new Date ( );
    }
}
