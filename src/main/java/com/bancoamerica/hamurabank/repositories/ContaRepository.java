package com.bancoamerica.hamurabank.repositories;

import com.bancoamerica.hamurabank.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Conta findById(long id);
    void deleteById(long id);
}
