package io.github.thefive40.back_tienda.mapper.clients;

import io.github.thefive40.back_tienda.model.dto.InvoiceDTO;
import io.github.thefive40.back_tienda.model.entity.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CClientMapper.class,CDetailInvoicesMapper.class})
public interface CInvoicesMapper {

    @Mappings ( {
            @Mapping( target = "client", ignore = true)
    } )
    InvoiceDTO toDto( InvoiceEntity entity );
    @Mappings ( {
            @Mapping( target = "client", ignore = true)
    } )
    InvoiceEntity toEntity( InvoiceDTO dto );

    List<InvoiceDTO> toDtoList( List<InvoiceEntity> entities );

    List<InvoiceEntity> toEntityList( List<InvoiceDTO> dtos );
}
