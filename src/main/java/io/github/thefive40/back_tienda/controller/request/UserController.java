package io.github.thefive40.back_tienda.controller.request;

import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.service.EncryptDataService;
import io.github.thefive40.back_tienda.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger ( UserController.class );
    private UserService userService;
    private EncryptDataService encryptDataService;

    public UserController ( UserService userService, EncryptDataService encryptDataService ) {
        this.userService = userService;
        this.encryptDataService = encryptDataService;
    }

    @GetMapping("/all")
    public List<ClientDTO> findAll () {
        var start = Instant.now ( );
        var user = userService.findAll ( );
        var end = Instant.now ( );
        logger.info ( "Tiempo de ejecución de la operación select:" + Duration.between ( start, end ).toMillis ( ) + " ms " );
        return user;
    }

    @GetMapping("/email/{email}")
    public ClientDTO getUserByEmail ( @PathVariable String email ) {
        var start = Instant.now ( );
        var user =  userService.findByEmail ( email );
        var end = Instant.now ( );
        logger.info ( "Tiempo de ejecución de la operación select:" + Duration.between ( start, end ).toMillis ( ) + " ms " );
        return user;
    }

    @PostMapping("/update")
    public ResponseEntity<String> update ( @RequestBody ClientDTO clientDTO ) throws Exception {
        ClientDTO user = userService.findByEmail ( clientDTO.getEmail ( ) );
        if (!clientDTO.getPassword ( ).equals ( user.getPassword ( ) )) {
            encryptDataService.encrypt ( clientDTO );
        }
        userService.saveUser ( clientDTO );
        return ResponseEntity.ok ( "User update successfully" );
    }

    @GetMapping("/password/{email}")
    public ClientDTO getPasswordByEmail ( @PathVariable String email ) {
        return userService.findPasswordByEmail ( email );
    }

    @GetMapping("/findByName/{name}")
    public List<ClientDTO> clientsByName ( @PathVariable String name ) {
        var start = Instant.now ( );
        var user =  userService.findByName ( name.replace ( "_", " " ) );
        var end = Instant.now ( );
        logger.info ( "Tiempo de ejecución de la operación select:" + Duration.between ( start, end ).toMillis ( ) + " ms " );
        return user;
    }

    @GetMapping("/findByLastName/{lastName}")
    public List<ClientDTO> clientsByLastName ( @PathVariable String lastName ) {
        return userService.findByLastName ( lastName.replace ( "_", " " ) );
    }
}
