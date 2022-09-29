package com.bancoamerica.hamurabank.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 5)
    private long conta;
    @Column(length = 5)
    private int agencia;
    @Column(length = 100)
    private String nome;
    @Column(length = 100000)
    private double saldo;

}
