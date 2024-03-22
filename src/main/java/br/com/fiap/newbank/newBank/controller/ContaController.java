package br.com.fiap.newbank.newBank.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.newbank.newBank.model.Conta;
import br.com.fiap.newbank.newBank.repository.ContaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("conta")
@Slf4j
public class ContaController {

    
    @Autowired
    ContaRepository contaRepository;

    @GetMapping
    public List<Conta>index(){
        return contaRepository.findAll();
    }

    @GetMapping("{numeroConta}")
    public ResponseEntity<Conta>getById(@PathVariable Long numeroConta){
        log.info("Busca por Numero de conta: {}", numeroConta);
        return contaRepository
        .findById(numeroConta)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<Conta>getByCpf(@PathVariable String cpf){
        log.info("Busca por cpf: {}", cpf);
        return contaRepository
        .findByCpf(cpf)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Conta create(@RequestBody @Valid Conta conta){
        log.info("Criando conta: {}", conta);
        return contaRepository.save(conta);
    }

    @DeleteMapping("{numeroConta}")
    @ResponseStatus(NO_CONTENT)
    public Conta encerrar(@PathVariable Long numeroConta){
        log.info("inativando conta: {}", numeroConta);

        Conta contaexistente = verificarSeExisteConta(numeroConta);

        contaexistente.setStatus(false);
        return contaRepository.save(contaexistente);

    }


     private void verificarSeExisteConta(Long numeroConta) {
        contaRepository
            .findById(numeroConta)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "conta não encontrada" )
            );
    }
    
}
