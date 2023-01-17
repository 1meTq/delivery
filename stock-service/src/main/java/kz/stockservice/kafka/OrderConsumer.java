package kz.stockservice.kafka;

import kz.baseservice.model.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderDto orderDto) {
        log.info("Consumer Stock received OrderDto:" + orderDto.toString());
    }

}
