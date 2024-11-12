package io.github.thefive40.back_tienda.repository;

import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.model.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {
    ShoppingCartEntity findByClient_Email( String client_email );
}
