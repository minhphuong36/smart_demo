package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class WalletUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double balance;
    private Date createAt;
    private Date updateAt;
    @OneToOne
    private User user;
}
