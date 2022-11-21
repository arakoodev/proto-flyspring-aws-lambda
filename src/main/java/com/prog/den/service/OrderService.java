package com.prog.den.service;

import com.prog.den.model.Order;
import com.prog.den.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public Order save(Order e) {
        return orderRepository.save(e);
    }

    public List<Order> list() {
        return orderRepository.findAll();
    }
}
