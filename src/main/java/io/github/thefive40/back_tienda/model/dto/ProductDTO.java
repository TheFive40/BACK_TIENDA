package io.github.thefive40.back_tienda.model.dto;
import io.github.thefive40.back_tienda.model.entity.DetailInvoiceEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDTO {
    private long productId;

    private String name;

    private String description;

    private double price;

    private String img;

    private Date dateRegistration;

    private ClientDTO client;

    private boolean status;

    private List<ReviewDTO> reviews = new ArrayList<> ( );

    private List<ProductCategoryDTO> productsCategory = new ArrayList<> ( );

    private List<DetailOrderDTO> detailsOrder = new ArrayList<> ( );

    private List<ItemCartDTO> itemsCart = new ArrayList<> ( );
    private List<DetailInvoiceDTO> invoices = new ArrayList<> (  );

}
