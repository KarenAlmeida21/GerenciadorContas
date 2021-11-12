package br.com.zup.GerenciadorContas.controllers;

import br.com.zup.GerenciadorContas.dtos.*;
import br.com.zup.GerenciadorContas.entity.Conta;
import br.com.zup.GerenciadorContas.enuns.Status;
import br.com.zup.GerenciadorContas.exceptions.StatusInvalidoException;
import br.com.zup.GerenciadorContas.services.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")

public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornoContaDto cadastrarConta(@RequestBody @Valid CadastrarDto conta) {
        Conta contafutura = modelMapper.map(conta, Conta.class);

        return modelMapper.map(contaService.salvarConta(contafutura), RetornoContaDto.class);
    }

    @GetMapping
    public List<FiltroContaDto> exibirContas() {
        List<FiltroContaDto> listaDeContas = new ArrayList<>();
        for (Conta contaReferencia : contaService.exibirConta()) {
            FiltroContaDto exibirContaFiltro = modelMapper.map(contaReferencia, FiltroContaDto.class);
            listaDeContas.add(exibirContaFiltro);
        }
        return listaDeContas;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RetornoContaDto informarPagamento(@PathVariable int id, @RequestBody RetornoContaDto contaDto) {
        if (contaDto.getStatus() == Status.PAGO) {
            return modelMapper.map(contaService.atualizarConta(id), (Type) RetornoContaDto.class);
        }
        throw new StatusInvalidoException("Este Status Não é Valido");

    }


}
