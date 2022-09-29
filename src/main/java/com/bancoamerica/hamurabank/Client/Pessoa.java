package com.bancoamerica.hamurabank.Client;

import lombok.Data;

@Data
public class Pessoa {

    private int id;
    private String name;

    public String toString() {
        return "id: " + id + "\nname: " + name;
    }

}
