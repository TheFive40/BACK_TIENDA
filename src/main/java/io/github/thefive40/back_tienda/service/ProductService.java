package io.github.thefive40.back_tienda.service;

import io.github.thefive40.back_tienda.mapper.clients.CClientMapper;
import io.github.thefive40.back_tienda.mapper.products.PProductMapper;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.dto.ProductDTO;
import io.github.thefive40.back_tienda.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CClientMapper CClientMapperImpl;
    private final PProductMapper productMapperImpl;

    public ProductService ( ProductRepository productRepository, CClientMapper CClientMapperImpl, PProductMapper productMapperImpl ) {
        this.productRepository = productRepository;
        this.CClientMapperImpl = CClientMapperImpl;
        this.productMapperImpl = productMapperImpl;
    }

    public ProductDTO findProductById ( ProductDTO product ) {
        return productMapperImpl.toDto ( productRepository.findById ( product.getProductId ( ) ).orElseThrow ( ) );
    }

    public List<ProductDTO> findAll () {
        return productMapperImpl.toDtoList ( productRepository.findAll ( ) );
    }

    public List<ProductDTO> findByClient ( ClientDTO clientDTO ) {
        return productMapperImpl.toDtoList ( productRepository.findByClient ( CClientMapperImpl.toEntity ( clientDTO ) ) );
    }

    public void saveProduct ( ProductDTO product ) {
        productRepository.save ( productMapperImpl.toEntity ( product ) );
    }

    public List<ProductDTO> findByClientName ( String name ) {
       return productMapperImpl.toDtoList ( productRepository.findProductEntitiesByClient_Name ( name ) );
    }

    public ProductDTO findProductByNameAndImgAndPrice ( String name, String img, double price ) {
        return productMapperImpl.toDto ( productRepository.findProductByNameAndImgAndPrice ( name,
                img, price ) );
    }

    public List<ProductDTO> findByName(String name){
        return productMapperImpl.toDtoList ( productRepository.findAllByName ( name ) );
    }
}
