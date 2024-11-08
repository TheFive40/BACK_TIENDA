package io.github.thefive40.back_tienda.model.dto;
import lombok.*;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Getter
@Setter
@ToString
public class ClientDTO  implements Cloneable, Serializable{

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

    private List<ProductDTO> products = new ArrayList<> ();

    private List<OrderDTO> orders = new ArrayList<> ();

    private List<ReviewDTO> reviews = new ArrayList<> ();

    private List<ShoppingCartDTO> shoppingCart = new ArrayList<> ();

    @Override
    public ClientDTO clone () {
        try {
            return (ClientDTO) super.clone ( );
        } catch (CloneNotSupportedException e) {
            throw new AssertionError ( );
        }
    }
}
