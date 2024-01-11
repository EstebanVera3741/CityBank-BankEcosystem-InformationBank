package org.example.citybankbankecosysteminformationbank.component.messaging.receiver;

import org.example.citybankbankecosysteminformationbank.builder.exception.InformationBankGeneralException;
import org.example.citybankbankecosysteminformationbank.builder.response.implement.InformationResponse;
import org.example.citybankbankecosysteminformationbank.common.constant.message.IInformationBankMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;

@Component
public class InformationBankReceiver
{
   @RabbitListener(queues = {"${sacavix.queue.receiver}"})
    public void receive(InformationResponse message)
    {
        processMessage(message);
    }

    private void processMessage(InformationResponse message)
    {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new InformationBankGeneralException(IInformationBankMessage.OPERATION_FAIL);
        }
    }
}