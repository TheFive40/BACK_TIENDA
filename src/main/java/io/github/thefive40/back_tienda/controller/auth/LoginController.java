package io.github.thefive40.back_tienda.controller.auth;
import io.github.thefive40.back_tienda.model.dto.UserDTO;
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
    private Logger logger = LoggerFactory.getLogger ( LoginController.class);
    private UserService userService;

    public LoginController ( UserService userService ) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginPost ( @RequestBody UserDTO userDTO ) {
        try {
            var user = userService.findByEmail ( userDTO.getEmail ( ) );
            if (user != null && user.getPassword ( ).equals ( userDTO.getPassword () )) {
                logger.info ( "¡Login successful!" );
                return ResponseEntity.ok ( "¡Login successful!" );
            } else {
                logger.error ( "¡Invalid credentials!" );
                return new ResponseEntity<> ( "Invalid credentials", HttpStatus.UNAUTHORIZED );
            }
        } catch (NullPointerException exception) {
            logger.error ( "¡Login failed!" );
            return new ResponseEntity<> ( "Login failed", HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDTO userDTO ){
        if(userService.findByEmail ( userDTO.getEmail () ) != null){
            return ResponseEntity.badRequest ().body ( "Email already registered" );
        }
        userService.saveUser ( userDTO );
        return ResponseEntity.ok ( "User created successfully" );
    }
}
