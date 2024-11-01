package io.github.thefive40.back_tienda.repository;

import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ClientEntity, Long> {
    @Query("SELECT u FROM ClientEntity u WHERE u.email = :email")
    Optional<ClientEntity> findByEmail ( @Param ( "email" ) String email );
}
