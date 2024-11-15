package io.github.thefive40.back_tienda.model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedidos")
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long idOrder;
    private double total;
    private Date orderDate;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    private String paymentMethod;
    private String discountCode;
    private boolean status;
    @ManyToOne(targetEntity = ClientEntity.class)
    @JoinColumn(name = "idClient_fk")
    private ClientEntity idClient;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailOrderEntity> detailOrder = new ArrayList<> (  );
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceEntity> invoices = new ArrayList<> (  );
    public OrderEntity ( String country, String city, String address, String zipCode, String paymentMethod, String discountCode, double total ) {
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.paymentMethod = paymentMethod;
        this.discountCode = discountCode;
        this.total = total;
        this.orderDate = new Date ( );
    }
}
