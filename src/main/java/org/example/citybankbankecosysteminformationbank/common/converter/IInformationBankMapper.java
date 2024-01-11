package org.example.citybankbankecosysteminformationbank.common.converter;

import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationBankDTO;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.InformationBankDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IInformationBankMapper {
    IInformationBankMapper INSTANCE = Mappers.getMapper(IInformationBankMapper.class);

    @Mapping(target = "id", ignore = true)
    InformationBankDocument DTOToDocument (InformationBankDTO informationBankDTO);

    @Mapping(target = "id")
    InformationBankDTO DocumentToDTO (InformationBankDocument informationBankDocument);
}