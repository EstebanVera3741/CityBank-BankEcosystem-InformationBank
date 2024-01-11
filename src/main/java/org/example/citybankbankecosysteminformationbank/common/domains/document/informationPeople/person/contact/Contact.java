package org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.person.contact;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Contact implements Serializable
{
    private String phoneNumber;
    private String emailAddress;
}