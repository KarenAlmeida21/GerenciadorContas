package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enuns.Tipo;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor

public class CadastrarDto {
    @Size(min = 2, message = "Um nome deve ter ao menos 2 caracteres")
    private String nome;
    @Min(value = 0, message = "O valor da conta deve ser superior a R$ 0")
    private double valor;
    private Tipo tipo;
    @NotEmpty(message = "Esse campo deve ser preenchido")
    private LocalDate dataDeVencimento;

}
