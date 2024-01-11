package org.example.citybankbankecosysteminformationbank.webApi.implement;

import lombok.RequiredArgsConstructor;
import org.example.citybankbankecosysteminformationbank.builder.exception.InformationBankGeneralException;
import org.example.citybankbankecosysteminformationbank.builder.response.InformationBankBuildReturn;
import org.example.citybankbankecosysteminformationbank.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationbank.common.constant.endPoint.informationBank.IInformationBankEndPoint;
import org.example.citybankbankecosysteminformationbank.common.constant.endPoint.informationPeople.IInformationPeopleEndPoint;
import org.example.citybankbankecosysteminformationbank.common.constant.message.IInformationBankMessage;
import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationBankDTO;
import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationPeopleDTO;
import org.example.citybankbankecosysteminformationbank.service.implement.InformationBankService;
import org.example.citybankbankecosysteminformationbank.webApi.IInformationBankApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(IInformationBankEndPoint.BASE_URL)
@RequiredArgsConstructor
public class InformationBankApi implements IInformationBankApi
{
    private final InformationBankService informationBankService;

    @Override
    @GetMapping(IInformationBankEndPoint.GET_INFORMATION_BANK)
    public ResponseEntity<InformationResponse> getInformationBank(@PathVariable String codeSwift)
    {
        return this.informationBankService.getInformationBank(codeSwift);
    }

    @Override
    @PostMapping(IInformationBankEndPoint.GET_INFORMATION_BANK)
    public ResponseEntity<InformationResponse> saveInformationBank(@RequestBody InformationBankDTO informationBankDTO)
    {
        return this.informationBankService.saveInformationBank(informationBankDTO);
    }

    @Override
    @GetMapping(IInformationBankEndPoint.GET_INFORMATION_PEOPLE)
    public ResponseEntity<InformationResponse> getInformationMember(@PathVariable String personIdentification)
    {
        return this.informationBankService.getInformationMember(personIdentification);
    }

    @Override
    @PostMapping(IInformationBankEndPoint.SAVE_INFORMATION_PEOPLE)
    public ResponseEntity<InformationResponse> saveInformationMember(@RequestBody InformationPeopleDTO informationPeopleDTO)
    {
        return this.informationBankService.saveInformationMember(informationPeopleDTO);
    }
}