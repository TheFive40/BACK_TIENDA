package io.github.thefive40.back_tienda.service;

import io.github.thefive40.back_tienda.mapper.clients.CClientMapper;
import io.github.thefive40.back_tienda.mapper.clients.CProductMapper;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.model.entity.ItemCartEntity;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import io.github.thefive40.back_tienda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private CClientMapper mapper;
    private CProductMapper CProductMapper;

    @Autowired
    public void setMapper ( CClientMapper mapper, CProductMapper CProductMapper ) {
        this.mapper = mapper;
        this.CProductMapper = CProductMapper;
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
        List<ProductEntity> productEntities = CProductMapper.toEntityList ( user.getProducts ( ) );
        productEntities.forEach ( e -> {
            e.setClient ( client );
        } );
        if (!user.getOrders ( ).isEmpty ( )) {
            client.getOrders ( ).forEach ( e -> {
                e.getDetailOrder ( ).forEach ( v -> {
                    v.setOrder ( e );
                    e.setIdClient ( client );
                } );
            } );
        }
        var shopping = client.getShoppingCart ( ).get ( 0 );
        for (ItemCartEntity e : shopping.getItemsCart ( )) {
            e.setShoppingCart ( shopping );
        }
        shopping.setClient ( client );
        client.setProducts ( productEntities );
        userRepository.save ( client );
    }

    public ClientDTO findPasswordByEmail ( String email ) {
        ClientEntity userEntity = userRepository.findByEmail ( email ).orElseThrow ( );
        ClientDTO clientDTO = new ClientDTO ( );
        clientDTO.setPassword ( userEntity.getPassword ( ) );
        return clientDTO;
    }

    public List<ClientDTO> findByName ( String name ) {
        List<ClientEntity> entities = userRepository.findAllByName ( name );
        return mapper.toDtoList ( entities );
    }

    public List<ClientDTO> findByLastName ( String lastname ) {
        List<ClientEntity> entities = userRepository.findAllByLastname ( lastname );
        return mapper.toDtoList ( entities );
    }
}
