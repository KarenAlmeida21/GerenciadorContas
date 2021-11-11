package br.com.zup.GerenciadorContas.controllers;

import br.com.zup.GerenciadorContas.Conta;
import br.com.zup.GerenciadorContas.dtos.CadastroContaDto;
import br.com.zup.GerenciadorContas.dtos.FiltroContaDto;
import br.com.zup.GerenciadorContas.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/nomes")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<FiltroContaDto>exibirContas() {
        List<FiltroContaDto> listaDeContas = new ArrayList<>();
       // for (Conta contaReferencia://) {

       // }

    }





}
