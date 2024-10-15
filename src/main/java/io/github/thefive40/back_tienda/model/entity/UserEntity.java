package io.github.thefive40.back_tienda.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    public UserEntity ( String email, String password, String name, String phone ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public UserEntity ( String email, String password, String name, String lastname, String phone ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
    }
}
