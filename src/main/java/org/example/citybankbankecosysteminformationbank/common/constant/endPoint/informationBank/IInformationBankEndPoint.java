package org.example.citybankbankecosysteminformationbank.common.constant.endPoint.informationBank;

public interface IInformationBankEndPoint
{
    String BASE_URL = "microserviceInformation-bank";
    String GET_INFORMATION_BANK = "/get-information-bank/{codeSwift}";
    String SAVE_NEW_BRANCH_BANK = "/save-information-bank";
    String GET_INFORMATION_PEOPLE = "/get-informationPeople/{personIdentification}";
    String SAVE_INFORMATION_PEOPLE = "/save-information-people";
}