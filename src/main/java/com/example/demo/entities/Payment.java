package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders order;

    private int status;



}
