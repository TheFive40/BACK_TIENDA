package io.github.thefive40.back_tienda.controller.request;

import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController ( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<ClientDTO> findAll(){
        return userService.findAll ();
    }

    @GetMapping("/email/{email}")
    public ClientDTO getUserByEmail ( @PathVariable String email ) {
        // Retrieve user from database and map it to UserDTO
        // Return the UserDTO
        return userService.findByEmail ( email );
    }

    @GetMapping("/password/{email}")
    public ClientDTO getPasswordByEmail ( @PathVariable String email ) {
        return userService.findPasswordByEmail(email);
    }
}
