package kz.orderservice.kafka;

import kz.baseservice.model.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProducer {

    private NewTopic topic;

    private KafkaTemplate<String, OrderDto>  kafkaTemplate;

    public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderDto> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderDto orderDto){
        log.info("Producer send OrderDto: " + orderDto.toString());
        Message<OrderDto> message = MessageBuilder
                .withPayload(orderDto)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
