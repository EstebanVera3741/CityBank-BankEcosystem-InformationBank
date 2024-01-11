package org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank;

import lombok.*;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.branch.Branch;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.contact.Contact;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "information_bank")
public class InformationBankDocument
{
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String codeSwift;
    @Field
    private String idFiscal;
    @Field
    private Contact contact;
    @Field
    private Branch branch;
}