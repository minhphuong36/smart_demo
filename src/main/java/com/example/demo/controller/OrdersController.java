package com.example.demo.controller;

import com.example.demo.dtos.OrdersDTO;
import com.example.demo.dtos.Response;
import com.example.demo.entities.Orders;
import com.example.demo.service.OrdersService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/savebill")
    public ResponseEntity<?> save(@RequestBody OrdersDTO ordersDTO) {
        String result =  ordersService.save(ordersDTO);
        Response response = new Response(200,result,null);
        return ResponseEntity.ok(response);
    }
}
