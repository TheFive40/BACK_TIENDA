package io.github.thefive40.back_tienda.model.dto;

import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;

public class ReviewDTO {
    private Long idReview;
    private ProductEntity product;
    private ClientEntity idClient;

}
