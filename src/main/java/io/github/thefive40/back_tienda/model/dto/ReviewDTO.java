package io.github.thefive40.back_tienda.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDTO {
    private long idReview;
    private ProductDTO product;
    private ClientDTO idClient;

}
