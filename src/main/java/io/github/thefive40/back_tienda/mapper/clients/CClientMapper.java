package io.github.thefive40.back_tienda.mapper.clients;
import io.github.thefive40.back_tienda.model.dto.ClientDTO;
import io.github.thefive40.back_tienda.model.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CProductMapper.class, CShoppingCartMapper.class, COrderMapper.class})

public interface CClientMapper {
    CClientMapper INSTANCE = Mappers.getMapper( CClientMapper.class);
    @Mapping(source = "idClient", target = "idClient")
    @Mapping(source = "registrationDate", target = "registrationDate")
    ClientDTO toDto( ClientEntity entity);
    @Mapping(source = "idClient", target = "idClient")
    @Mapping(source = "registrationDate", target = "registrationDate")
    ClientEntity toEntity(ClientDTO dto);

    List<ClientDTO> toDtoList( List<ClientEntity> entities);

    List<ClientEntity> toEntityList(List<ClientDTO> dtos);

}
