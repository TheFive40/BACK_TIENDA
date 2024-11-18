package io.github.thefive40.back_tienda.controller.request;

import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.dto.ProductDTO;
import io.github.thefive40.back_tienda.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    private Logger logger = LoggerFactory.getLogger ( UserController.class );

    private final ProductService productService;

    public ProductController ( ProductService productService ) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public List<ProductDTO> findAllProducts () {
        var start = Instant.now ( );
        var products = productService.findAll ( );
        var end = Instant.now ( );
        logger.info ( "Tiempo de ejecución de la operación select:" + Duration.between ( start, end ).toMillis ( ) + " ms " );
        return products;
    }

    @PostMapping("/findByClient")
    public List<ProductDTO> findByClient ( @RequestBody ClientDTO clientDTO ) {
        return productService.findByClient ( clientDTO );
    }

    @PostMapping("/findById")
    public List<ProductDTO> findProductById ( @RequestBody ProductDTO productDTO ) {
        return List.of ( productService.findProductById ( productDTO ) );
    }

    @PostMapping("/add")
    public List<ProductDTO> addProduct ( @RequestBody ProductDTO productDTO ) {
        var start = Instant.now ( );
        productService.saveProduct ( productDTO );
        var end = Instant.now ( );
        logger.info ( "Tiempo de ejecución de la operación insert:" + Duration.between ( start, end ).toMillis ( ) + " ms " );
        return null;
    }

    @GetMapping("/findByName/{name}/{img}/{price}")
    public ProductDTO findProductByNameAndImgAndPrice ( @PathVariable String name, @PathVariable String img, @PathVariable double price ) {
        String image = "/static/media/images/products/" + img;
        String nombre = name.replace ( "_", " " );
        return productService.findProductByNameAndImgAndPrice ( nombre, image, price );
    }

    @GetMapping("/findProductsByClientName/{name}")
    public List<ProductDTO> findProductsByClientName ( @PathVariable String name ) {
        var start = Instant.now ( );
        var products = productService.findByClientName ( name.replace ( "_", " " ) );
        var end = Instant.now ( );
        logger.info ( "Tiempo de ejecución de la operación select:" + Duration.between ( start, end ).toMillis ( ) + " ms " );
        return products;
    }

    @GetMapping("/findProductName/{name}")
    public List<ProductDTO> findByName ( @PathVariable String name ) {
        var start = Instant.now ( );
        var products = productService.findByName ( name.replace ( "_", " " ) );
        var end = Instant.now ( );
        logger.info ( "Tiempo de ejecución de la operación select:" + Duration.between ( start, end ).toMillis ( ) + " ms " );
        return products;
    }
}
