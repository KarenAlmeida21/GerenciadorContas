package br.com.zup.GerenciadorContas.repositories;

import br.com.zup.GerenciadorContas.entity.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer> {

}
