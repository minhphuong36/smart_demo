package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date orderDate;
    private Double totalPrice;
    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

    private int status;

    @ManyToOne
    private Inventory inventory;

}
