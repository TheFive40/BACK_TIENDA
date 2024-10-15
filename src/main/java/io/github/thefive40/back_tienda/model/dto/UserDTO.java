package io.github.thefive40.back_tienda.model.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO implements Cloneable, Serializable {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String lastName;

    private String phone;

    @Lob
    private byte[] image;

    public UserDTO ( String email, String password ) {
        this.email = email;
        this.password = password;
    }

    @Override
    public UserDTO clone () {
        try {
            // TODO: copy mutable
            //  state here, so the clone can't change the internals of the original
            return (UserDTO) super.clone ( );
        } catch (CloneNotSupportedException e) {
            throw new AssertionError ( );
        }
    }
}
