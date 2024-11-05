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

    private List<ProductDTO> products = new ArrayList<> ();

    public long getIdClient () {
        return idClient;
    }

    public void setIdClient ( long idClient ) {
        this.idClient = idClient;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getLastname () {
        return lastname;
    }

    public void setLastname ( String lastname ) {
        this.lastname = lastname;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone ( String phone ) {
        this.phone = phone;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl ( String url ) {
        this.url = url;
    }

    public Date getRegistrationDate () {
        return registrationDate;
    }

    public void setRegistrationDate ( Date registrationDate ) {
        this.registrationDate = registrationDate;
    }

    public String getSecret_key () {
        return secret_key;
    }

    public void setSecret_key ( String secret_key ) {
        this.secret_key = secret_key;
    }

    public String getInitVector () {
        return initVector;
    }

    public void setInitVector ( String initVector ) {
        this.initVector = initVector;
    }

    public List<ProductDTO> getProducts () {
        return products;
    }

    public void setProducts ( List<ProductDTO> products ) {
        this.products = products;
    }

    public List<OrderDTO> getOrders () {
        return orders;
    }

    public void setOrders ( List<OrderDTO> orders ) {
        this.orders = orders;
    }

    public List<ReviewDTO> getReviews () {
        return reviews;
    }

    public void setReviews ( List<ReviewDTO> reviews ) {
        this.reviews = reviews;
    }

    public List<ShoppingCartDTO> getShoppingCart () {
        return shoppingCart;
    }

    public void setShoppingCart ( List<ShoppingCartDTO> shoppingCart ) {
        this.shoppingCart = shoppingCart;
    }

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
