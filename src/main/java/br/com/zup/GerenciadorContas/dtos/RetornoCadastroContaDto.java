package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enuns.Status;
import br.com.zup.GerenciadorContas.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RetornoCadastroContaDto {
    private int id;
    private String nome;
    private double valor;
    private Tipo tipo;

}
