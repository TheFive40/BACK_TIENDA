package io.github.thefive40.back_tienda.controller.auth;

import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.service.EncryptDataService;
import io.github.thefive40.back_tienda.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger ( LoginController.class );
    private UserService userService;
    private EncryptDataService encryptDataService;

    public LoginController ( UserService userService, EncryptDataService encryptDataService ) {
        this.userService = userService;
        this.encryptDataService = encryptDataService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginPost ( @RequestBody ClientDTO clientDTO ) {
        try {
            var user = userService.findByEmail ( clientDTO.getEmail ( ) );
            if (user == null) return new ResponseEntity<> ( "Login failed", HttpStatus.NOT_FOUND );
            var text = encryptDataService.decrypt ( user.getPassword ( ), user.getSecret_key ( )
                    , user.getInitVector ( ) );
            if (clientDTO.getPassword ( ).equals ( text )) {
                logger.info ( "¡Login successful!" );
                return ResponseEntity.ok ( "¡Login successful!" );
            } else {
                logger.error ( "¡Invalid credentials!" );
                logger.info ( "Desencrypt text: " + text );
                return new ResponseEntity<> ( "Invalid credentials", HttpStatus.UNAUTHORIZED );
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace ( );
            logger.error ( "¡Login failed!" );
            return new ResponseEntity<> ( "Login failed", HttpStatus.INTERNAL_SERVER_ERROR );
        } catch (Exception e) {
            throw new RuntimeException ( e );
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp ( @RequestBody ClientDTO clientDTO ) {
        if (userService.findByEmail ( clientDTO.getEmail ( ) ) != null) {
            return ResponseEntity.badRequest ( ).body ( "Email already registered" );
        }
        encryptDataService.encrypt ( clientDTO );
        userService.saveUser ( clientDTO );
        return ResponseEntity.ok ( "User created successfully" );
    }
}
