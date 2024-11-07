package com.example.pratica2bimestre.service;

import com.example.pratica2bimestre.model.Tarefa;
import com.example.pratica2bimestre.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Facade responsável por realizar a comunicação entre o repositório e a camada de serviço.
 */
@Service
public class TarefaFacade {

    private final TarefaRepository tarefaRepository;

    public TarefaFacade(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa save(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> findById(Integer id) {
        return tarefaRepository.findById(id);
    }

    public void delete(Tarefa tarefa) {
        tarefaRepository.delete(tarefa);
    }
}
