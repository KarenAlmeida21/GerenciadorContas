package br.com.zup.GerenciadorContas.dtos;

import br.com.zup.GerenciadorContas.enuns.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AtualizarContaDto {
    private Status status;

}
