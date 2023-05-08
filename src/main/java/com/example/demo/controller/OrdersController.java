package com.example.demo.controller;

import com.example.demo.dtos.OrdersDTO;
import com.example.demo.entities.Orders;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/savebill")
    public Orders save(@RequestBody OrdersDTO ordersDTO) {
        return ordersService.save(ordersDTO);
    }
}
