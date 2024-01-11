package org.example.citybankbankecosysteminformationbank.common.converter;

import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationPeopleDTO;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.InformationPeopleDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IInformationPeopleMapper
{
    IInformationPeopleMapper INSTANCE = Mappers.getMapper(IInformationPeopleMapper.class);

    @Mapping(target = "id", ignore = true)
    InformationPeopleDocument DTOToDocument (InformationPeopleDTO informationPeopleDTO);

    @Mapping(target = "id")
    InformationPeopleDTO DocumentToDTO (InformationPeopleDocument informationPeopleDocument);
}