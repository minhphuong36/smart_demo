package com.example.demo.service;

import com.example.demo.dtos.DataDTO;
import com.example.demo.dtos.OrdersDTO;
import com.example.demo.entities.OrderDetail;
import com.example.demo.entities.Orders;
import com.example.demo.entities.Product;
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


    public String save(OrdersDTO ordersDTO) throws RuntimeException {
        Integer userId = ordersDTO.getUserId();
        Date ordersDate = ordersDTO.getOrderDate();

        Double totalPrice = ordersDTO.getTotalPrice();
        List<DataDTO> data = ordersDTO.getData();

        Orders orders = null;
        if (!data.isEmpty() && checkValidQuantity(data)) {
//          Lưu orders
            orders = new Orders();
            orders.setOrderDate((java.sql.Date) ordersDate);
            orders.setUser(iUserRepository.findById(userId).get());
            orders.setStatus(1);
            orders.setTotalPrice(totalPrice);
            Orders newOrders = ordersRepository.save(orders);

            for (DataDTO dt : data) {
//              Lưu orderDetail
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrders(newOrders);
                orderDetail.setProduct(productRepository.findById(dt.getId()).get());
                orderDetail.setStatus(1);
                orderDetail.setQuantity(dt.getQuantity());
                orderDetailRepository.save(orderDetail);

                Product product = productRepository.findById(dt.getId()).get();
                product.setQuantity(product.getQuantity() - orderDetail.getQuantity());


            }
            return "mua hang thanh cong";

        } else {
            return "Het hang";
        }

    }


//               Kiểm tra số lượng mua và só dư trong kho.
    private boolean checkValidQuantity(List<DataDTO> dataDTOS) {
        boolean check = true;
        try {
            for (DataDTO dt : dataDTOS) {
                Product product = productRepository.findById(dt.getId()).get();
                if (product.getQuantity() < dt.getQuantity()) {
                    check = false;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }


}
