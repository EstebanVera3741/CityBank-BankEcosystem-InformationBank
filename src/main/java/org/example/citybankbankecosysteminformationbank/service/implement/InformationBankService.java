package org.example.citybankbankecosysteminformationbank.service.implement;

import lombok.RequiredArgsConstructor;
import org.example.citybankbankecosysteminformationbank.builder.exception.InformationBankGeneralException;
import org.example.citybankbankecosysteminformationbank.builder.response.InformationBankBuildReturn;
import org.example.citybankbankecosysteminformationbank.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationbank.common.constant.endPoint.informationPeople.IInformationPeopleEndPoint;
import org.example.citybankbankecosysteminformationbank.common.constant.information.IInformationBankConst;
import org.example.citybankbankecosysteminformationbank.common.constant.message.IInformationBankMessage;
import org.example.citybankbankecosysteminformationbank.common.converter.IInformationBankMapper;
import org.example.citybankbankecosysteminformationbank.common.converter.IInformationBankMapperImpl;
import org.example.citybankbankecosysteminformationbank.common.converter.IInformationPeopleMapper;
import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationBankDTO;
import org.example.citybankbankecosysteminformationbank.common.domains.DTO.InformationPeopleDTO;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.InformationBankDocument;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.InformationPeopleDocument;
import org.example.citybankbankecosysteminformationbank.component.messaging.sender.InformationBankSender;
import org.example.citybankbankecosysteminformationbank.repository.IInformationBankRepository;
import org.example.citybankbankecosysteminformationbank.service.IInformationBankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InformationBankService implements IInformationBankService
{
    private final IInformationBankRepository iInformationBankRepository;
    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity<InformationResponse> getInformationBank
            (
                    String codeSwift
            )
    {
        try
        {
            Optional<InformationBankDocument> informationBankDocumentExist =
                    this.iInformationBankRepository.findAllByCodeSwift(codeSwift);

            if (informationBankDocumentExist.isEmpty())
            {
                return InformationBankBuildReturn.buildReturnFailed
                        (
                                IInformationBankMessage.OPERATION_FAIL,
                                IInformationBankMessage.READ_FAIL,
                                null
                        );
            }
            InformationBankDTO informationBankDTO =
                    IInformationBankMapper.INSTANCE.DocumentToDTO(informationBankDocumentExist.get());

            return InformationBankBuildReturn.buildReturnSuccess
                    (
                            IInformationBankMessage.OPERATION_SUCCESS,
                            informationBankDTO,
                            informationBankDTO.getId()
                    );
        }catch (Exception e)
        {
            throw new InformationBankGeneralException(IInformationBankMessage.OPERATION_FAIL);
        }
    }

    @Override
    public ResponseEntity<InformationResponse> saveInformationBank
            (
                    InformationBankDTO informationBankDTO
            )
    {
        try
        {
            Optional<InformationBankDocument> informationBankDocumentExist =
                    this.iInformationBankRepository.findAllByCodeSwift(informationBankDTO.getCodeSwift());

            if (informationBankDocumentExist.isPresent())
            {
                return InformationBankBuildReturn.buildReturnFailed
                        (
                                IInformationBankMessage.OPERATION_FAIL,
                                IInformationBankMessage.CREATE_FAIL,
                                null
                        );
            }

            InformationBankDocument informationBankDocument =
                    IInformationBankMapper.INSTANCE.DTOToDocument(informationBankDTO);

            this.iInformationBankRepository.save(informationBankDocument);

            return InformationBankBuildReturn.buildReturnSuccess
                    (
                            IInformationBankMessage.OPERATION_SUCCESS,
                            IInformationBankMessage.CREATE_SUCCESS,
                            null
                    );
        }catch (Exception e)
        {
            throw new InformationBankGeneralException(IInformationBankMessage.OPERATION_FAIL);
        }
    }

    @Override
    public ResponseEntity<InformationResponse> getInformationMember
            (
                    String personIdentification
            )
    {
        String BASE_URL = IInformationPeopleEndPoint.BASE_HTTP + IInformationPeopleEndPoint.BASE_URL;
        String GET_METHOD = IInformationPeopleEndPoint.GET_CREDIT_HISTORY_MEMBER;

        try {
            return restTemplate.getForEntity
                    (
                            BASE_URL + GET_METHOD,
                            InformationResponse.class,
                            personIdentification
                    );
        } catch (HttpClientErrorException e) {

            return InformationBankBuildReturn.buildReturnFailed
                    (
                            IInformationBankMessage.OPERATION_FAIL,
                            IInformationBankMessage.READ_FAIL,
                            null
                    );
        }
    }

    @Override
    public ResponseEntity<InformationResponse> saveInformationMember
            (
                    InformationPeopleDTO informationPeopleDTO
            )
    {
        try
        {
            ResponseEntity<InformationResponse> informationMember =
                    this.getInformationMember(informationPeopleDTO.getPerson().getIdentification());

            if (informationMember.getBody().getStatusCode().equals(HttpStatus.OK.value()))
            {
                return InformationBankBuildReturn.buildReturnFailed
                        (
                                IInformationBankMessage.OPERATION_FAIL,
                                IInformationBankMessage.MEMBER_EXIST,
                                null
                        );
            }

            Optional<InformationBankDocument> informationBankDocumentExist =
                    this.iInformationBankRepository.findAllByCodeSwift
                            (
                                    IInformationBankConst.CODE_SWIFT
                            );

            InformationBankDTO informationBankDTO =
                    IInformationBankMapper.INSTANCE.DocumentToDTO
                            (
                                    informationBankDocumentExist.orElse(null)
                            );

            informationPeopleDTO.setInformationBank(informationBankDTO);

            InformationPeopleDocument informationPeopleDocument =
                    IInformationPeopleMapper.INSTANCE.DTOToDocument
                            (
                                    informationPeopleDTO
                            );

            String BASE_URL = IInformationPeopleEndPoint.BASE_HTTP + IInformationPeopleEndPoint.BASE_URL;
            String GET_METHOD = IInformationPeopleEndPoint.SAVE_INFORMATION_MEMBER;

            try {
                return restTemplate.postForEntity
                        (
                                BASE_URL + GET_METHOD,
                                informationPeopleDocument,
                                InformationResponse.class
                        );
            } catch (HttpClientErrorException e) {

                return InformationBankBuildReturn.buildReturnFailed
                        (
                                IInformationBankMessage.OPERATION_FAIL,
                                IInformationBankMessage.READ_FAIL,
                                null
                        );
            }
        }catch (Exception e)
        {
            throw new InformationBankGeneralException(IInformationBankMessage.OPERATION_FAIL);
        }
    }
}