package br.com.zup.GerenciadorContas.service;

import br.com.zup.GerenciadorContas.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContaService {
    @Autowired
    private ContaRepository ContaRepository;


}
