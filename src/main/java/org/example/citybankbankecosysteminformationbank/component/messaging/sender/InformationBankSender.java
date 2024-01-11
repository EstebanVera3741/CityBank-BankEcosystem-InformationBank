package org.example.citybankbankecosysteminformationbank.component.messaging.sender;

import lombok.RequiredArgsConstructor;
import org.example.citybankbankecosysteminformationbank.builder.response.implement.InformationResponse;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
@RequiredArgsConstructor
public class InformationBankSender
{
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public void send(InformationResponse message)
    {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}