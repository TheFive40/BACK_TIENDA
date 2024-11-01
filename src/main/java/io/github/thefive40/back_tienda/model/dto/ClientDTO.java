package io.github.thefive40.back_tienda.model.dto;
import io.github.thefive40.back_tienda.model.entity.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDTO  implements Cloneable, Serializable{

    private Long idClient;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String lastName;

    private String phone;

    private String url;

    private String secretKey;

    private String initVector;

    private Date registrationDate;

    private List<ProductDTO> products = new ArrayList<> ();

    private List<OrderDTO> orders = new ArrayList<> ();

    private List<ReviewDTO> reviews = new ArrayList<> ();

    private List<ShoppingCartDTO> shoppingCart = new ArrayList<> ();

    public ClientDTO ( String email, String password ) {
        this.email = email;
        this.password = password;
    }

    public ClientDTO ( String email, String password, String name, String lastName, String phone, String url, String secretKey, String initVector ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.url = url;
        this.secretKey = secretKey;
        this.initVector = initVector;
    }

    @Override
    public ClientDTO clone () {
        try {
            return (ClientDTO) super.clone ( );
        } catch (CloneNotSupportedException e) {
            throw new AssertionError ( );
        }
    }
}
