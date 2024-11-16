package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Table(name = "Cliente")
@Entity
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long idClient;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private String url;

    private Date registrationDate;

    private String secret_key;

    private String initVector;

    private String role;

    private boolean status;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<> ( );
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orders = new ArrayList<> ( );
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviews = new ArrayList<> ( );
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingCartEntity> shoppingCart = new ArrayList<> ( );
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<> (  );

}
