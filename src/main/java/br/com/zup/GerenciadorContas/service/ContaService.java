package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.Conta;
import br.com.zup.GerenciadorContas.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {
    @Autowired
    private ContaRepository ContaRepository;


    public Conta salvarConta(Conta conta){
        ContaRepository.save(conta);
        return conta;
    }





}
