package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.Conta;
import br.com.zup.GerenciadorContas.enuns.Status;
import br.com.zup.GerenciadorContas.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class CadastroContaDto {
    private String nome;
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;


    public class ExibirContaDTO {
        private int id;
        private String nome;
        private double valor;
        private Status status;
    }

}
