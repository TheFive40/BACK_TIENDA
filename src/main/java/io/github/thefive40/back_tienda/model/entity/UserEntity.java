package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.BlobJdbcType;

import java.sql.Blob;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuarios")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private String url;

    private String secret_key;

    private String initVector;


    public UserEntity ( String email, String password, String name, String lastname, String phone, String url, String secret_key, String initVector ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.url = url;
        this.secret_key = secret_key;
        this.initVector = initVector;
    }

}
