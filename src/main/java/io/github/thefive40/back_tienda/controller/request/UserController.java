package io.github.thefive40.back_tienda.controller.request;

import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.service.EncryptDataService;
import io.github.thefive40.back_tienda.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    private EncryptDataService encryptDataService;

    public UserController ( UserService userService, EncryptDataService encryptDataService ) {
        this.userService = userService;
        this.encryptDataService = encryptDataService;
    }

    @GetMapping("/all")
    public List<ClientDTO> findAll () {
        return userService.findAll ( );
    }

    @GetMapping("/email/{email}")
    public ClientDTO getUserByEmail ( @PathVariable String email ) {
        // Retrieve user from database and map it to UserDTO
        // Return the UserDTO
        return userService.findByEmail ( email );
    }

    @PostMapping("/update")
    public ResponseEntity<String> update ( @RequestBody ClientDTO clientDTO ) throws Exception {
        ClientDTO user = userService.findByEmail ( clientDTO.getEmail ( ) );
        if(!clientDTO.getPassword ().equals ( user.getPassword () )){
            encryptDataService.encrypt ( clientDTO );
        }

        userService.saveUser ( clientDTO );
        return ResponseEntity.ok ( "User update successfully" );
    }

    @GetMapping("/password/{email}")
    public ClientDTO getPasswordByEmail ( @PathVariable String email ) {
        return userService.findPasswordByEmail ( email );
    }
}
