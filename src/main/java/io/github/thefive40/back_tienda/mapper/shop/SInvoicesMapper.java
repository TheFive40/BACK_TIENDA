package io.github.thefive40.back_tienda.mapper.shop;

import io.github.thefive40.back_tienda.mapper.products.PClientMapper;
import io.github.thefive40.back_tienda.mapper.products.PDetailInvoicesMapper;
import io.github.thefive40.back_tienda.model.dto.InvoiceDTO;
import io.github.thefive40.back_tienda.model.entity.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { SClientMapper.class, SDetailInvoicesMapper.class})
public interface SInvoicesMapper {
    @Mappings( {
            @Mapping( target = "client",ignore = true)
    } )
    InvoiceDTO toDto( InvoiceEntity entity );
    @Mappings ( {
            @Mapping ( target = "client",ignore = true)
    } )
    InvoiceEntity toEntity( InvoiceDTO dto );
    List<InvoiceEntity> toEntityList( List<InvoiceDTO> dtos);
    List<InvoiceDTO> toDtoList( List<InvoiceEntity> entities);
}
