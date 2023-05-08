package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private int status;

}
