package kz.stockservice.service.impl;

import kz.stockservice.model.Order;
import kz.stockservice.repository.OrderRepository;
import kz.stockservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
