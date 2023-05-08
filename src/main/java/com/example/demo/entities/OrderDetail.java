package com.example.demo.entities;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Orders orders;
    private int status;
}
