package org.example.citybankbankecosysteminformationbank.common.domains.document.informationPeople.person.employment;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Employment implements Serializable
{
    private String companyName;
    private String position;
    private double monthlyIncome;
}