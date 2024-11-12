package io.github.thefive40.back_tienda.controller.request;

import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.dto.ProductDTO;
import io.github.thefive40.back_tienda.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    private final ProductService productService;

    public ProductController ( ProductService productService ) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public List<ProductDTO> findAllProducts () {
        return productService.findAll ( );
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
        productService.saveProduct ( productDTO );
        return null;
    }

    @GetMapping("/findByName/{name}/{img}/{price}")
    public ProductDTO findProductByNameAndImgAndPrice ( @PathVariable String name, @PathVariable String img, @PathVariable double price ) {
        String image = "/static/media/images/products/" + img;
        String nombre = name.replace ( "_", " " );
        System.out.println ( image );
        System.out.println ( nombre );
        System.out.println (price );
        return productService.findProductByNameAndImgAndPrice ( nombre, image, price );
    }
}
