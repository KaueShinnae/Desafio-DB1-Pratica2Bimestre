package com.example.pratica2bimestre.repository;

import com.example.pratica2bimestre.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de repositório responsável por realizar as operações de CRUD sobre a entidade Tarefa.
 */
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
