package com.example.pratica2bimestre.service;

import com.example.pratica2bimestre.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço responsável por realizar as regras de negócio relacionadas às tarefas.
 */
@Service
public class TarefaService {

    private final TarefaFacade tarefaFacade;

    // Injeção de dependência do Facade no Service
    public TarefaService(TarefaFacade tarefaFacade) {
        this.tarefaFacade = tarefaFacade;
    }

    /**
     * Adiciona uma nova tarefa ao sistema.
     *
     * @param tarefa Tarefa a ser adicionada.
     * @return Tarefa adicionada.
     */
    public Tarefa addTarefa(Tarefa tarefa) {
        return tarefaFacade.save(tarefa);
    }

    /**
     * Busca todas as tarefas cadastradas.
     *
     * @return Lista de todas as tarefas.
     */
    public List<Tarefa> getTarefas() {
        return tarefaFacade.findAll();
    }

    /**
     * Busca uma tarefa específica pelo seu ID.
     *
     * @param id ID da tarefa a ser buscada.
     * @return Tarefa encontrada.
     * @throws RuntimeException Caso a tarefa não seja encontrada.
     */
    public Tarefa getTarefaById(Integer id) {
        return tarefaFacade.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));
    }

    /**
     * Atualiza as informações de uma tarefa existente.
     *
     * @param id ID da tarefa a ser atualizada.
     * @param tarefaAtualizada Tarefa com as novas informações.
     * @return Tarefa atualizada.
     * @throws RuntimeException Caso a tarefa não seja encontrada.
     */
    public Tarefa updateTarefa(Integer id, Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = tarefaFacade.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));

        tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
        tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
        tarefaExistente.setStatus(tarefaAtualizada.getStatus());
        tarefaExistente.setPrioridade(tarefaAtualizada.getPrioridade());
        tarefaExistente.setDataFinal(tarefaAtualizada.getDataFinal());

        return tarefaFacade.save(tarefaExistente);
    }

    /**
     * Deleta uma tarefa pelo seu ID.
     *
     * @param id ID da tarefa a ser deletada.
     * @throws RuntimeException Caso a tarefa não seja encontrada.
     */
    public void deleteTarefa(Integer id) {
        Tarefa tarefa = tarefaFacade.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));
        tarefaFacade.delete(tarefa);
    }
}
