package io.github.thefive40.back_tienda.mapper.clients;

import io.github.thefive40.back_tienda.model.dto.InvoiceDTO;
import io.github.thefive40.back_tienda.model.entity.InvoiceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {COrderMapper.class})
public interface CInvoicesMapper {
    InvoiceDTO toDto( InvoiceEntity entity );

    InvoiceEntity toEntity( InvoiceDTO dto );

    List<InvoiceDTO> toDtoList( List<InvoiceEntity> entities );

    List<InvoiceEntity> toEntityList( List<InvoiceDTO> dtos );
}
