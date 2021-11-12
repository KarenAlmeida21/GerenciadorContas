package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enuns.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class CadastrarDto {
    @Size(min = 2, message = "Um nome deve ter ao menos 2 caracteres")
    private String nome;

    @DecimalMin(value = "0.01", message = "O valor da conta deve ser superior a R$ 0.01")
    private double valor;

    private Tipo tipo;

    @NotNull(message = "A data de vencimento deve ser informada")
    private LocalDate dataDeVencimento;

}
