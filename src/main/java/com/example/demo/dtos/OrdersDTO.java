package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {
    private int id;
    private Date orderDate;
    private Double totalPrice;
    private int quantity;
    private double price;
    private int userId;
    private int status;
    private List<DataDTO> data;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice(double v) {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice =  price*quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }



}
