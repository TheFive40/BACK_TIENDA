package io.github.thefive40.back_tienda.mapper.clients;
import io.github.thefive40.back_tienda.model.dto.DetailInvoiceDTO;
import io.github.thefive40.back_tienda.model.entity.DetailInvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CProductMapper.class, CInvoicesMapper.class})

public interface CDetailInvoicesMapper {
    @Mappings ( {
            @Mapping ( target = "invoice",ignore = true)
    } )
    DetailInvoiceDTO toDto( DetailInvoiceEntity entity );
    @Mappings ( {
            @Mapping ( target = "invoice",ignore = true)
    } )
    DetailInvoiceEntity toEntity( DetailInvoiceDTO dto );
    List<DetailInvoiceEntity> toEntityList( List<DetailInvoiceDTO> dtos);
    List<DetailInvoiceDTO> toDtoList( List<DetailInvoiceEntity> entities);
}
