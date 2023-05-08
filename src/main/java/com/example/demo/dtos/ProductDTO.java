package com.example.demo.dtos;

import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private String img;
    private String price;
    private int quantity;
    private int status;
}
