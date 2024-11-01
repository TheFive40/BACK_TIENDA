package io.github.thefive40.back_tienda.service;

import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
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

    public ClientDTO getUserDTO ( Long id ) {
        ClientEntity entity = userRepository.findById ( id ).orElseThrow ( );
        return new ClientDTO ( entity.getEmail ( ), entity.getPassword ( ) );
    }

    public ClientDTO findByEmail ( String email ) {
        ClientEntity entity = userRepository.findByEmail ( email ).orElse ( null );
        if (entity == null) return null;
        ClientDTO clientDTO = new ClientDTO ( entity.getEmail ( ), entity.getPassword ( ), entity.getName ( ),
                entity.getLastname ( ), entity.getPhone ( ), entity.getUrl ( ), entity.getSecret_key ( ), entity.getInitVector ( ) );
        clientDTO.setProducts ( entity.getProducts () );
        clientDTO.setOrders ( entity.getOrders () );
        clientDTO.setReviews ( entity.getReviews () );
        clientDTO.setShoppingCart ( entity.getShoppingCart () );
        return clientDTO;
    }

    public void saveUser ( ClientDTO user ) {
        userRepository.save ( new ClientEntity ( user.getEmail ( ), user.getPassword ( )
                , user.getName ( ), user.getLastName ( ), user.getPhone ( ), user.getUrl ( ), user.getSecretKey ( ),
                user.getInitVector ( ) ) );
    }

    public ClientDTO findPasswordByEmail ( String email ) {
        ClientEntity userEntity = userRepository.findByEmail ( email ).orElseThrow ( );
        ClientDTO clientDTO = new ClientDTO ( );
        clientDTO.setPassword ( userEntity.getPassword ( ) );
        return clientDTO;
    }
}
