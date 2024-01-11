package org.example.citybankbankecosysteminformationbank.webApi;

import org.example.citybankbankecosysteminformationbank.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationbank.common.constant.endPoint.informationBank.IInformationBankEndPoint;
import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationBankDTO;
import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationPeopleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IInformationBankApi
{
    @GetMapping(IInformationBankEndPoint.GET_INFORMATION_BANK)
    ResponseEntity<InformationResponse> getInformationBank
            (@PathVariable String codeSwift);

    @PostMapping(IInformationBankEndPoint.SAVE_NEW_BRANCH_BANK)
    ResponseEntity<InformationResponse> saveInformationBank
            (@RequestBody InformationBankDTO informationBankDTO);

    @GetMapping(IInformationBankEndPoint.GET_INFORMATION_PEOPLE)
    ResponseEntity<InformationResponse> getInformationMember
            (@PathVariable String personIdentification);

    @PostMapping(IInformationBankEndPoint.SAVE_INFORMATION_PEOPLE)
    ResponseEntity<InformationResponse> saveInformationMember
            (@RequestBody InformationPeopleDTO informationPeopleDTO);
}