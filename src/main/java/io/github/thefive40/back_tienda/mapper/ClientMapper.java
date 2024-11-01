package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.dto.DetailOrderDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import io.github.thefive40.back_tienda.model.entity.DetailOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, OrderMapper.class, ReviewMapper.class, ShoppingCartMapper.class })

public interface ClientMapper {
    @Mapping(source = "idClient", target = "idClient")
    @Mapping(source = "registrationDate", target = "registrationDate")
    ClientDTO toDto( ClientEntity entity);
    @Mapping(source = "idClient", target = "idClient")
    @Mapping(source = "registrationDate", target = "registrationDate")
    ClientEntity toEntity(ClientDTO dto);

    List<ClientDTO> toDtoList( List<ClientEntity> entities);

    List<ClientEntity> toEntityList(List<ClientDTO> dtos);
    DetailOrderEntity map( DetailOrderDTO value);

}
