package io.github.thefive40.back_tienda.controller.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.thefive40.back_tienda.model.dto.*;
import io.github.thefive40.back_tienda.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private Logger logger = LoggerFactory.getLogger ( CartController.class );

    @Autowired
    private ShoppingCartService service;

    @PostMapping("/save")
    public void postCart ( @RequestBody ShoppingCartDTO cartDTO ) {
        service.save ( cartDTO );
    }

    @PostMapping("/update")
    public void updateItemCart ( @RequestBody ItemCartDTO itemCartDTO ) {
        var start = Instant.now ( );
        service.updateItemCart ( itemCartDTO );
        var end = Instant.now ( );
        logger.info ( "Tiempo de ejecución de la operación update:" + Duration.between ( start, end ).toMillis ( ) + " ms " );
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
    @PostMapping("/remove")
    public void removeItemCart(@RequestBody ItemCartDTO itemCartDTO){
        service.delete ( itemCartDTO );
    }
}
