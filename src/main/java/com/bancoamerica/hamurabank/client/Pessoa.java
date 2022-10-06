package com.bancoamerica.hamurabank.client;

import lombok.Data;

@Data
public class Pessoa {

    private int id;
    private String name;

    public String toString() {
        return "id: " + id + "\nname: " + name;
    }

}
