package com.bancoamerica.hamurabank.controllers;

import com.bancoamerica.hamurabank.models.Conta;
import com.bancoamerica.hamurabank.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> listaTodasContas () {
        return new ResponseEntity<List<Conta>>(contaService.listaTodasContas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> listaContaPorId (@PathVariable long id) {
        return new ResponseEntity<Conta>(contaService.listaContaPorId(id), HttpStatus.OK);
    }

    @PostMapping("/cria")
    public ResponseEntity<Conta> criaConta (@RequestBody Conta conta) {
        Conta contaRetorno = contaService.criaConta(conta);

        if (contaRetorno != null) {
            return new ResponseEntity<>(contaRetorno, HttpStatus.CREATED);
        } return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atualiza")
    public ResponseEntity<Conta> atualizaContaPorId (@RequestBody Conta conta) {
        Conta contaRetorno = contaService.atualizaConta(conta);

        if (contaRetorno != null) {
            return new ResponseEntity<>(contaRetorno, HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<Conta> deletaContaPorId (@PathVariable long id) {
        contaService.deletaConta(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
