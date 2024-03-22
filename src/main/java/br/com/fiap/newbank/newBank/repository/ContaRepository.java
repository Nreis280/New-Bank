package br.com.fiap.newbank.newBank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.newbank.newBank.model.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long>{

    Optional<Conta> findByCpf(String cpf);

    void setStatus(boolean b);
    
}
