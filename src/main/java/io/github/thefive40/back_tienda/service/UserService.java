package io.github.thefive40.back_tienda.service;

import io.github.thefive40.back_tienda.mapper.ClientMapper;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private ClientMapper mapper;

    @Autowired
    public void setMapper ( ClientMapper mapper ) {
        this.mapper = mapper;
    }

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository ( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public ClientDTO getUserDTO ( Long id ) {
        ClientEntity entity = userRepository.findById ( id ).orElseThrow ( );
        return mapper.toDto ( entity );
    }

    public ClientDTO findByEmail ( String email ) {
        ClientEntity entity = userRepository.findByEmail ( email ).orElse ( null );
        if (entity == null) return null;
        ClientDTO client = mapper.toDto ( entity );
        return client;
    }

    public List<ClientDTO> findAll () {
        return mapper.toDtoList ( userRepository.findAll ( ) );
    }

    public void saveUser ( ClientDTO user ) {
        ClientEntity client = new ClientEntity ( );
        client.setEmail ( user.getEmail ( ) );
        client.setPassword ( user.getPassword ( ) );
        client.setName ( user.getName ( ) );
        client.setLastname ( user.getLastname ( ) );
        client.setPhone ( user.getPhone ( ) );
        client.setUrl ( user.getUrl ( ) );
        client.setSecret_key ( user.getSecret_key ( ) );
        client.setInitVector ( user.getInitVector ( ) );
        userRepository.save ( client );
    }

    public ClientDTO findPasswordByEmail ( String email ) {
        ClientEntity userEntity = userRepository.findByEmail ( email ).orElseThrow ( );
        ClientDTO clientDTO = new ClientDTO ( );
        clientDTO.setPassword ( userEntity.getPassword ( ) );
        return clientDTO;
    }
}
