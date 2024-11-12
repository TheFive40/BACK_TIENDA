package io.github.thefive40.back_tienda.controller.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.thefive40.back_tienda.model.dto.*;
import io.github.thefive40.back_tienda.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private ShoppingCartService service;

    @PostMapping("/save")
    public void postCart ( @RequestBody ShoppingCartDTO cartDTO ) {
        service.save ( cartDTO );
    }

    @PostMapping("/update")
    public void updateItemCart ( @RequestBody ItemCartDTO itemCartDTO ) {
        service.updateItemCart ( itemCartDTO );
    }

    @PostMapping("/findByClient")
    public ShoppingCartDTO findByClient ( @RequestBody ClientDTO clientDTO ) {
        return service.findByClient ( clientDTO );
    }
    @PostMapping("/findItemCart")
    public ItemCartDTO findByProductAndShoppingCart( @RequestBody RequestProductShopDto request){
        var x = service.findByProductAndShoppingCart ( request.getProduct (), request.getShoppingCart () );
        return x;
    }
}
