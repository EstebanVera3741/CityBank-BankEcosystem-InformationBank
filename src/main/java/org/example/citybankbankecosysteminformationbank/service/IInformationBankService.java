package org.example.citybankbankecosysteminformationbank.service;

import org.example.citybankbankecosysteminformationbank.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationBankDTO;
import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationPeopleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IInformationBankService
{
    public ResponseEntity<InformationResponse> getInformationBank
            (String codeSwift);
    ResponseEntity<InformationResponse> saveInformationBank
            (InformationBankDTO informationBankDTO);

    ResponseEntity<InformationResponse> getInformationMember
            (String personIdentification);

    ResponseEntity<InformationResponse> saveInformationMember
            (InformationPeopleDTO informationPeopleDTO);
}