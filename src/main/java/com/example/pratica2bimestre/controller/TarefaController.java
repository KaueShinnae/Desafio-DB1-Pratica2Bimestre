package com.example.pratica2bimestre.controller;

import com.example.pratica2bimestre.model.Tarefa;
import com.example.pratica2bimestre.service.TarefaService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

/**
 * Controlador REST responsável pelas operações CRUD sobre a entidade Tarefa.
 */
@RestController
@RequestMapping("tasks")
public class TarefaController {

    // Serviço responsável por gerenciar as tarefas.
    private final TarefaService tarefaService;

    /**
     * Construtor para a classe TarefaController.
     *
     * @param tarefaService Serviço responsável por gerenciar as tarefas.
     */
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    /**
     * Adiciona uma nova tarefa ao sistema.
     *
     * @param tarefa Objeto do tipo Tarefa que deve ser adicionado.
     * @return A tarefa adicionada.
     */
    @Operation(summary = "Adicionar uma nova tarefa", description = "Adiciona uma nova tarefa ao sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa adicionada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public Tarefa addTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.addTarefa(tarefa);
    }

    /**
     * Retorna todas as tarefas cadastradas.
     *
     * @return Lista de todas as tarefas.
     */
    @Operation(summary = "Buscar todas as tarefas", description = "Retorna uma lista com todas as tarefas cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista de tarefas retornada com sucesso")
    @GetMapping
    public List<Tarefa> getTarefas() {
        return tarefaService.getTarefas();
    }

    /**
     * Retorna os detalhes de uma tarefa específica pelo ID.
     *
     * @param id ID da tarefa buscada.
     * @return A tarefa correspondente ao ID fornecido.
     */
    @Operation(summary = "Buscar uma tarefa por ID", description = "Retorna os detalhes de uma tarefa específica pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @GetMapping("/{id}")
    public Tarefa getTarefaById(@PathVariable Integer id) {
        return tarefaService.getTarefaById(id);
    }

    /**
     * Atualiza as informações de uma tarefa já existente.
     *
     * @param id ID da tarefa a ser atualizada.
     * @param tarefa Tarefa com as informações atualizadas.
     * @return A tarefa que foi atualizada.
     */
    @Operation(summary = "Atualizar uma tarefa", description = "Atualiza as informações de uma tarefa existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PutMapping("/{id}")
    public Tarefa updateTarefa(@PathVariable Integer id, @RequestBody Tarefa tarefa) {
        return tarefaService.updateTarefa(id, tarefa);
    }

    /**
     * Remove uma tarefa do sistema pelo seu ID.
     *
     * @param id ID da tarefa a ser deletada.
     */
    @Operation(summary = "Deletar uma tarefa", description = "Remove uma tarefa do sistema pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable Integer id) {
        tarefaService.deleteTarefa(id);
    }
}
