package br.com.zup.GerenciadorContas.controllers;

import br.com.zup.GerenciadorContas.entity.Conta;
import br.com.zup.GerenciadorContas.dtos.FiltroContaDto;
import br.com.zup.GerenciadorContas.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

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
    public void informarPagamento(){

    }
}
