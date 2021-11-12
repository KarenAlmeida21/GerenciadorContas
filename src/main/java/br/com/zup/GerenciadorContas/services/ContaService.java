package br.com.zup.GerenciadorContas.services;
import br.com.zup.GerenciadorContas.entity.Conta;
import br.com.zup.GerenciadorContas.enuns.Status;
import br.com.zup.GerenciadorContas.exceptions.ContaNaoLocalizadaException;
import br.com.zup.GerenciadorContas.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class ContaService {

    @Autowired
    private Conta conta;

    @Autowired
    private ContaRepository contaRepository;

    public ContaService() {
    }

    public List<Conta> exibirConta() {
        Iterable<Conta> listaDeContas = contaRepository.findAll();

        return (List<Conta>) listaDeContas;
    }


    public Conta salvarConta(Conta conta) {
        verificarDatas(conta);
        contaRepository.save(conta);
        return conta;
    }

    public void verificarDatas(Conta conta) {
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }
    }

    public Conta buscarContaporId(int id) {
        Optional<Conta> contaId = contaRepository.findById(id);
        if (contaId.isEmpty()) {
            throw new ContaNaoLocalizadaException();
        }
        return contaId.get();
    }


    public Conta atualizarConta(int id) {
        Conta conta = buscarContaporId(id);
        conta.setStatus(Status.PAGO);
        conta.setDataDePagamento(LocalDateTime.now());
        return conta;
    }


}








