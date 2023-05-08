package com.example.demo.dtos;

import com.example.demo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {
    private int id;
    private Date orderDate;
    private Double totalPrice;
    private int userId;
    private int status;
    private List<DataDTO> data;

}
