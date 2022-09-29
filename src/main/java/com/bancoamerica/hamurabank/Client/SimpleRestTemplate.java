package com.bancoamerica.hamurabank.Client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SimpleRestTemplate {


    public Pessoa[] pegarListaDePessoasProcuradas () {

        RestTemplate template = new RestTemplate();

        //https://jsonplaceholder.typicode.com/users

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("jsonplaceholder.typicode.com")
                .path("users")
                .build();

        ResponseEntity<Pessoa[]> arrayDePessoas = template.getForEntity(uri.toUriString(), Pessoa[].class);

        return arrayDePessoas.getBody();
    }

}
