package io.github.thefive40.back_tienda.service;

import io.github.thefive40.back_tienda.mapper.ClientMapper;
import io.github.thefive40.back_tienda.mapper.ProductMapper;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import io.github.thefive40.back_tienda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private ClientMapper mapper;
    private ProductMapper productMapper;

    @Autowired
    public void setMapper ( ClientMapper mapper, ProductMapper productMapper ) {
        this.mapper = mapper;
        this.productMapper = productMapper;
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
        return mapper.toDto ( entity );
    }

    public List<ClientDTO> findAll () {
        return mapper.toDtoList ( userRepository.findAll ( ) );
    }

    public void saveUser ( ClientDTO user ) {
        ClientEntity client = mapper.toEntity ( user );
        List<ProductEntity> productEntities = productMapper.toEntityList ( user.getProducts ( ) );
        productEntities.forEach ( e -> {
            e.setClient ( client );
        } );
        client.setProducts ( productEntities );
        userRepository.save ( client );
    }

    public ClientDTO findPasswordByEmail ( String email ) {
        ClientEntity userEntity = userRepository.findByEmail ( email ).orElseThrow ( );
        ClientDTO clientDTO = new ClientDTO ( );
        clientDTO.setPassword ( userEntity.getPassword ( ) );
        return clientDTO;
    }
}
