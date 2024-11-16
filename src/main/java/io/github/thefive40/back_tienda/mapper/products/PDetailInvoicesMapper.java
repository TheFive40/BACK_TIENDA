package io.github.thefive40.back_tienda.mapper.products;
import io.github.thefive40.back_tienda.mapper.clients.CInvoicesMapper;
import io.github.thefive40.back_tienda.model.dto.DetailInvoiceDTO;
import io.github.thefive40.back_tienda.model.entity.DetailInvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PProductMapper.class, PInvoicesMapper.class})

public interface PDetailInvoicesMapper {
    @Mappings ( {
            @Mapping( target = "product", ignore = true),
            @Mapping( target = "invoice", ignore = true)

    } )
    DetailInvoiceDTO toDto( DetailInvoiceEntity entity );
    @Mappings ( {
            @Mapping( target = "product", ignore = true),
            @Mapping( target = "invoice", ignore = true)

    } )
    DetailInvoiceEntity toEntity( DetailInvoiceDTO dto );
    List<DetailInvoiceEntity> toEntityList( List<DetailInvoiceDTO> dtos);
    List<DetailInvoiceDTO> toDtoList( List<DetailInvoiceEntity> entities);
}
