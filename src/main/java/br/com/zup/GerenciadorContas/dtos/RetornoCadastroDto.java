package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RetornoCadastroDto {
    private int id;
    private String nome;
    private double valor;
    private Tipo tipo;
}
