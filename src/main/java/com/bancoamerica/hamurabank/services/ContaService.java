package com.bancoamerica.hamurabank.services;

import com.bancoamerica.hamurabank.client.SimpleRestTemplate;
import com.bancoamerica.hamurabank.client.Pessoa;
import com.bancoamerica.hamurabank.models.Conta;
import com.bancoamerica.hamurabank.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private SimpleRestTemplate simpleRestTemplate;

    public List<Conta> listaTodasContas() {
        return contaRepository.findAll();
    }

    public Conta listaContaPorId(long id) {
        return contaRepository.findById(id);
    }

    public Conta atualizaConta(Conta contaAtualizada) throws NullPointerException {
        Conta conta = this.listaContaPorId(contaAtualizada.getId());
        conta.setNome(contaAtualizada.getNome());
        contaRepository.save(conta);
        return conta;
    }

    public void deletaConta(long id) {
        contaRepository.deleteById(id);
    }

    public Conta criaConta(Conta conta) {
        if (!existePessoaNaListaDeProcurados(conta.getNome())) {
            return contaRepository.save(conta);
        }
        return null;
    }

    private boolean existePessoaNaListaDeProcurados(String nome) {
        Pessoa[] pessoas = simpleRestTemplate.pegarListaDePessoasProcuradas();
        boolean pessoaEncontrada = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getName().equals(nome)) {
                pessoaEncontrada = true;
                break;
            }
        }
        return pessoaEncontrada;
    }
}

