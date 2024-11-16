package io.github.thefive40.back_tienda.service;

import io.github.thefive40.back_tienda.mapper.clients.CClientMapper;
import io.github.thefive40.back_tienda.mapper.clients.CItemCartMapper;
import io.github.thefive40.back_tienda.mapper.clients.CProductMapper;
import io.github.thefive40.back_tienda.mapper.items.IItemCartMapper;
import io.github.thefive40.back_tienda.mapper.shop.SClientMapper;
import io.github.thefive40.back_tienda.mapper.shop.SItemCartMapper;
import io.github.thefive40.back_tienda.mapper.shop.SProductMapper;
import io.github.thefive40.back_tienda.mapper.shop.SShopingCartMapper;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.dto.ItemCartDTO;
import io.github.thefive40.back_tienda.model.dto.ProductDTO;
import io.github.thefive40.back_tienda.model.dto.ShoppingCartDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.model.entity.ShoppingCartEntity;
import io.github.thefive40.back_tienda.repository.ItemsCartRepository;
import io.github.thefive40.back_tienda.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    private SShopingCartMapper mapper;

    @Autowired
    private IItemCartMapper itemsCartMapper;
    @Autowired
    private ShoppingCartRepository repository;
    @Autowired
    private SProductMapper CProductMapper;
    @Autowired
    private SClientMapper CClientMapper;
    @Autowired
    private ItemsCartRepository itemsCartRepository;

    private ShoppingCartEntity entity;

    public void save ( ShoppingCartDTO cartDTO ) {

        entity = mapper.toEntity ( cartDTO );
        entity.getItemsCart ( ).forEach ( e -> {
            e.setShoppingCart ( entity );
        } );
        repository.saveAndFlush ( entity );
    }

    public ShoppingCartDTO findByClient (  ClientDTO clientDTO ) {
        var x = mapper.toDto ( repository.findByClient_Email ( clientDTO.getEmail ( ) ) );
        System.out.println ( x.getIdCart ( ) );
        return x;
    }

    public ItemCartDTO findByProductAndShoppingCart ( ProductDTO productDTO, ShoppingCartDTO shoppingCart ) {
        var product = CProductMapper.toEntity ( productDTO );
        var shoppingCartEntity = mapper.toEntity ( shoppingCart );
        return itemsCartMapper.toDto ( itemsCartRepository.findByProductAndShoppingCart ( product, shoppingCartEntity ) );
    }

    public void updateItemCart ( ItemCartDTO itemCartDTO ) {
        var entity = itemsCartMapper.toEntity ( itemCartDTO );

        itemsCartRepository.save ( entity );
    }
    public void delete(ItemCartDTO itemCartDTO){
        itemsCartRepository.deleteById ( itemCartDTO.getIdCart () );
    }
}
