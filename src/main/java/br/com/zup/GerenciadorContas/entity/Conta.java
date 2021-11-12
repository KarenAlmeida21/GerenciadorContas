package br.com.zup.GerenciadorContas.entity;

import br.com.zup.GerenciadorContas.enuns.Status;
import br.com.zup.GerenciadorContas.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "contas")

@Getter
@Setter
@NoArgsConstructor

public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private double valor;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(nullable = false)
    private LocalDate dataDeVencimento;
    @Column(nullable = true)
    private LocalDateTime dataDePagamento;
    @Enumerated(EnumType.STRING)
    private Status status;


}

