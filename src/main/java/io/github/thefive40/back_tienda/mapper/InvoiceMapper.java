package io.github.thefive40.back_tienda.mapper;

import io.github.thefive40.back_tienda.model.dto.InvoiceDTO;
import io.github.thefive40.back_tienda.model.entity.InvoiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderMapper.class, ProductMapper.class})
public interface InvoiceMapper {
    InvoiceDTO toDto( InvoiceEntity dto );
    InvoiceEntity toEntity( InvoiceDTO entity );
}
