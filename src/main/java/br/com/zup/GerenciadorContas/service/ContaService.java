package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.Conta;
import br.com.zup.GerenciadorContas.enuns.Status;
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
        verificarDatas(conta);
        return conta;
    }
    public void verificarDatas(Conta conta){
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())){
        conta.setStatus(Status.VENCIDA);
        } else conta.setStatus(Status.AGUARDANDO);
    }
}





