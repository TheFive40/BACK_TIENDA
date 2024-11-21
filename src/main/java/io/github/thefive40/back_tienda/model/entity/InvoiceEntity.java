package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Factura")
@Getter
@Setter
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInvoice;

    private int nroInvoice;
    @ManyToOne
    @JoinColumn(name = "id_client_fk")
    private ClientEntity client;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailInvoiceEntity> detailsInvoice = new ArrayList<> (  );
    private Date startDate;

    private double subTotal;

    private double tax;

    private double discount;

    private double total;

    private boolean status;

    public InvoiceEntity(){
        this.nroInvoice = (int)idInvoice;
    }
}
