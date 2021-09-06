package com.example.securitybasedrestapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USERID")
    private Long userid;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

}
