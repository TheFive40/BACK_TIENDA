package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cliente")
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idClient;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private String url;

    private Date registrationDate;

    private String secret_key;

    private String initVector;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<> ();
    @OneToMany(mappedBy="idClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orders = new ArrayList<> ();
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviews = new ArrayList<> ();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingCartEntity> shoppingCart = new ArrayList<> ();
    public ClientEntity ( String email, String password, String name, String lastname, String phone, String url, String secret_key, String initVector ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.url = url;
        this.secret_key = secret_key;
        this.initVector = initVector;
        this.registrationDate = new Date (  );
    }

}
