package org.example.citybankbankecosysteminformationbank.common.domains.DTO;

import lombok.*;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.branch.Branch;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.contact.Contact;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InformationBankDTO
{
    private String id;
    private String name;
    private String codeSwift;
    private String idFiscal;
    private Contact contact;
    private Branch branch;
}