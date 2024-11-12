package io.github.thefive40.back_tienda.repository;

import io.github.thefive40.back_tienda.model.entity.ItemCartEntity;
import io.github.thefive40.back_tienda.model.entity.ProductEntity;
import io.github.thefive40.back_tienda.model.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsCartRepository extends JpaRepository<ItemCartEntity, Long> {
    ItemCartEntity findByProductAndShoppingCart( ProductEntity product, ShoppingCartEntity shoppingCart );
}
