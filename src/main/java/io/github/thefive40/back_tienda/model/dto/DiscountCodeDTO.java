package io.github.thefive40.back_tienda.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class DiscountCodeDTO {
    private long idDiscount;

    private String code;

    private double percentage;

    private Date startDate;

    private Date endDate;
}
