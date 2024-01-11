package org.example.citybankbankecosysteminformationbank.common.constant.endPoint.informationPeople;

public interface IInformationPeopleEndPoint
{
    String BASE_HTTP = "http://localhost:8080/";
    String BASE_URL = "microserviceInformation-people";
    String GET_CREDIT_HISTORY_MEMBER = "/get/{personIdentification}";
    String SAVE_INFORMATION_MEMBER = "/save-InformationMember";
}