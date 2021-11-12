package br.com.zup.GerenciadorContas.controllers;

import br.com.zup.GerenciadorContas.dtos.*;
import br.com.zup.GerenciadorContas.entity.Conta;
import br.com.zup.GerenciadorContas.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public RetornoCadastroContaDto cadastrarConta(@RequestBody CadastrarDto conta) {
        Conta contafutura = modelMapper.map(conta, Conta.class);

        return modelMapper.map(contaService.salvarConta(contafutura), RetornoCadastroContaDto.class);
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
    public RetornoStatusDto atualizarConta(@PathVariable int id, @RequestBody RetornoStatusDto retornoStatusDto) {

        return modelMapper.map(contaService.atualizarConta(id), (Type) RetornoStatusDto.class);

    }


}
