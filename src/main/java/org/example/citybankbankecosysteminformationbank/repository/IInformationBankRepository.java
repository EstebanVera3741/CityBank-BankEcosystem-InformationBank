package org.example.citybankbankecosysteminformationbank.repository;

import org.example.citybankbankecosysteminformationbank.common.domains.document.informationBank.InformationBankDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface IInformationBankRepository extends MongoRepository<InformationBankDocument, String>
{
    Optional<InformationBankDocument> findAllByCodeSwift(String codeSwift);
}