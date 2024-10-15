package io.github.thefive40.back_tienda.service;
import io.github.thefive40.back_tienda.model.dto.UserDTO;
import io.github.thefive40.back_tienda.model.entity.UserEntity;
import io.github.thefive40.back_tienda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository ( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserDTO(Long id){
        UserEntity entity =  userRepository.findById ( id ).orElseThrow ( );
        return new UserDTO ( entity.getEmail (),entity.getPassword () );
    }

    public UserDTO findByEmail(String email){
        System.out.println (userRepository.findAll () );
        UserEntity entity =  userRepository.findAll ().stream ().
                filter ( e-> e.getEmail ().equalsIgnoreCase ( email ) ).findFirst ().orElse (null);
        if (entity == null ){
            return null;
        }
        return new UserDTO ( entity.getEmail (),entity.getPassword () );
    }

    public void saveUser ( UserDTO user ) {
        userRepository.save ( new UserEntity (user.getEmail (),user.getPassword ()
        , user.getName (),user.getLastName (),user.getPhone ()) );
    }

    public UserDTO findPasswordByEmail ( String email ) {

        return null;
    }
}
