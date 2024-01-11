package org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.person;

import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.contact.Contact;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.person.address.Address;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.person.creditHistory.CreditHistory;
import org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.person.employment.Employment;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class Person implements Serializable
{
    private String identification;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private Address address;
    private Contact contact;
    private Employment employment;
    private CreditHistory creditHistory;
}