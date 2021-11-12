package br.com.zup.GerenciadorContas.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RetornoStatusDto {
    private int id;
    private String nome;
    private double valor;
}
