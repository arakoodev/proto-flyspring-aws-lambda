package com.prog.den.controller;

import com.prog.den.model.Order;
import com.prog.den.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public Order create(@RequestBody Order r) {
        return orderService.save(r);
    }

    @GetMapping("")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<Order> list() {
        return orderService.list();
    }
}
