package kz.stockservice.kafka;

import kz.baseservice.model.dto.OrderDto;
import kz.stockservice.model.Order;
import kz.stockservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderConsumer {

    private final OrderService orderService;


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderDto orderDto) {

        Order order = new Order();
        order.setName(orderDto.getName());
        order.setQuantity(orderDto.getQuantity());
        order.setPrice(orderDto.getPrice());

        orderService.save(order);

        log.info("Consumer Stock received OrderDto:" + orderDto.toString());
    }

}
