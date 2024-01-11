package org.example.citybankbankecosysteminformationbank.builder.response.implement;

import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InformationResponse implements Serializable
{
    public String message;
    public Object objectResponse;
    public String objectId;
    public Integer statusCode;
}