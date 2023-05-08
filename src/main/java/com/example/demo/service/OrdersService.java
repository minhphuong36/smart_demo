package com.example.demo.service;

import com.example.demo.dtos.DataDTO;
import com.example.demo.dtos.OrdersDTO;
import com.example.demo.entities.OrderDetail;
import com.example.demo.entities.Orders;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.security.repo.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrdersService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;


    public Orders save(OrdersDTO ordersDTO) throws RuntimeException {
        Integer userId = ordersDTO.getUserId();
        Date ordersDate = ordersDTO.getOrderDate();
        Double totalPrice = ordersDTO.getTotalPrice();
        List<DataDTO> data = ordersDTO.getData();

        Orders orders = null;
        if(!data.isEmpty()){
            orders = new Orders();
            orders.setOrderDate((java.sql.Date) ordersDate);
            orders.setUser(iUserRepository.findById(userId).get());
            orders.setStatus(1);
            orders.setTotalPrice(totalPrice);
            Orders newOrders = ordersRepository.save(orders);

            for (DataDTO dt: data) {

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrders(newOrders);
                orderDetail.setProduct(productRepository.findById(dt.getId()).get());
                orderDetail.setStatus(1);
                orderDetail.setQuantity(dt.getQuantity());

                orderDetailRepository.save(orderDetail);
            }

        }
        return orders;



    }

}
