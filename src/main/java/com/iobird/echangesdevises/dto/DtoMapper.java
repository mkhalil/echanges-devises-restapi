package com.iobird.echangesdevises.dto;


import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.TauxDevise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring",  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DtoMapper {

    DtoMapper INSTANCE = Mappers.getMapper(DtoMapper.class);

    @Mappings({
            @Mapping(target = "deviseId", source = "devise.id"),
            @Mapping(target = "abreviation", source = "devise.abreviation"),
            @Mapping(target = "symbole", source = "devise.symbole"),
            @Mapping(target = "unite", source = "devise.unite"),
    })
    TauxDeviseDto toDto(TauxDevise tauxDevise);

    DeviseDto toDto (Devise devise);
}
