package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Codigo_Descuentos")
@Getter
@Setter
public class DiscountCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDiscount;

    private String code;

    private double percentage;

    private Date startDate;

    private Date endDate;

}
