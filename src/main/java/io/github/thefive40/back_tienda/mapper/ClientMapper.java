package io.github.thefive40.back_tienda.mapper;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = { ProductMapper.class, OrderMapper.class, ReviewMapper.class, ShoppingCartMapper.class })
public interface ClientMapper {
    ClientDTO toDto( ClientEntity clientEntity);
    ClientEntity toEntity(ClientDTO clientDTO);
}
