package io.github.thefive40.back_tienda.repository;

import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p WHERE p.client.idClient = :client")
    List<ProductEntity> findByClient ( @Param("client") ClientEntity client );

    ProductEntity findProductByNameAndImgAndPrice ( String name, String img, double price );

    List<ProductEntity> findProductEntitiesByClient_Name ( String name );
}
