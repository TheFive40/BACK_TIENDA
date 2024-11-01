package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Codigo_Descuentos")
public class DiscountCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiscount;

    private String code;

    private double percentage;

    private Date startDate;

    private Date endDate;

}
