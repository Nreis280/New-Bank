package br.com.fiap.newbank.newBank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.newbank.newBank.validation.TipoConta;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Conta {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroConta;

    @NotBlank(message = "{conta.agencia.notblank}") 
    private String agencia;

    @NotBlank(message = "{conta.nomeTitular.notblank}")
    private String nomeTitular;

    @NotBlank
    @Size(min= 11, max = 11, message = "{conta.cpf.size}")
    private String cpf;

    @PastOrPresent
    private LocalDate dtAbertura;

    @Positive(message = "{conta.saldoInicial.positive}")
    private BigDecimal saldoInicial;

    private Boolean status;

    @TipoConta(message = "{conta.tipo.tipoconta}")
    private String tipo;    
}
