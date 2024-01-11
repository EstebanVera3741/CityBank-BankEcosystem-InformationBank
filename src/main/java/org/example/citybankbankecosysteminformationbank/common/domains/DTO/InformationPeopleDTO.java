package org.example.citybankbankecosysteminformationbank.common.domains.DTO;

import lombok.*;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.person.Person;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.InformationBankDocument;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InformationPeopleDTO implements Serializable
{
    private String id;
    private Person person;
    private InformationBankDTO informationBank;
}