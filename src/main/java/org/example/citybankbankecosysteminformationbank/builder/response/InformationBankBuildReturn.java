package org.example.citybankbankecosysteminformationbank.builder.response;

import org.example.citybankbankecosysteminformationbank.builder.response.implement.InformationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InformationBankBuildReturn
{
    public static ResponseEntity<InformationResponse> buildReturnSuccess
            (
                    String message,
                    Object objectResponse,
                    String objectId
            )
    {
        return ResponseEntity.ok(InformationResponse.builder()
                .message(message)
                .objectResponse(objectResponse)
                .objectId(objectId)
                .statusCode(HttpStatus.OK.value())
                .build());
    }

    public static ResponseEntity<InformationResponse> buildReturnFailed
            (
                    String message,
                    Object objectResponse,
                    String objectId
            )
    {
        return ResponseEntity.badRequest().body(InformationResponse.builder()
                .message(message)
                .objectResponse(objectResponse)
                .objectId(objectId)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }
}