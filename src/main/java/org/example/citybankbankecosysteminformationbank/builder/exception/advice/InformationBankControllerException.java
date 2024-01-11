package org.example.citybankbankecosysteminformationbank.builder.exception.advice;

import org.example.citybankbankecosysteminformationbank.builder.exception.InformationBankGeneralException;
import org.example.citybankbankecosysteminformationbank.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationbank.common.constant.message.IInformationBankMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InformationBankControllerException
{
    @ExceptionHandler(InformationBankGeneralException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<InformationResponse> informationBankException
            (
                    InformationBankGeneralException informationBankGeneralException
            )
    {
        return ResponseEntity.badRequest().body(InformationResponse.builder()
                .message(informationBankGeneralException.getMessage())
                .objectResponse(IInformationBankMessage.INTERNAL_SERVER)
                .objectId(null)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }
}