package com.example.pratica2bimestre.controller;

import com.example.pratica2bimestre.model.Tarefa;
import com.example.pratica2bimestre.service.TarefaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Classe de teste para verificar o comportamento dos endpoints da TarefaController.
 * Testa operações de criação, consulta, atualização e exclusão de tarefas.
 */
@WebMvcTest(TarefaController.class)
public class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TarefaService tarefaService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Testa o endpoint para adicionar uma nova tarefa.
     * Verifica se a tarefa é adicionada corretamente e se a resposta contém os valores esperados.
     */
    @Test
    void testAddTarefa() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Nova Tarefa");
        tarefa.setDescricao("Descrição da nova tarefa");

        when(tarefaService.addTarefa(any(Tarefa.class))).thenReturn(tarefa);

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Nova Tarefa"));
    }

    /**
     * Testa o endpoint para buscar todas as tarefas.
     * Verifica se a lista de tarefas é retornada corretamente.
     */
    @Test
    void testGetTarefas() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Teste Tarefa");

        when(tarefaService.getTarefas()).thenReturn(List.of(tarefa));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Teste Tarefa"));
    }

    /**
     * Testa o endpoint para buscar uma tarefa pelo ID.
     * Verifica se a tarefa correta é retornada com base no ID fornecido.
     */
    @Test
    void testGetTarefaById() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1);
        tarefa.setTitulo("Teste Tarefa");

        when(tarefaService.getTarefaById(1)).thenReturn(tarefa);

        mockMvc.perform(get("/tasks/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Teste Tarefa"));
    }

    /**
     * Testa o endpoint para atualizar uma tarefa existente.
     * Verifica se a tarefa é atualizada corretamente e se a resposta contém os valores esperados.
     */
    @Test
    void testUpdateTarefa() throws Exception {
        Tarefa tarefaAtualizada = new Tarefa();
        tarefaAtualizada.setTitulo("Tarefa Atualizada");

        when(tarefaService.updateTarefa(any(Integer.class), any(Tarefa.class))).thenReturn(tarefaAtualizada);

        mockMvc.perform(put("/tasks/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tarefaAtualizada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Tarefa Atualizada"));
    }

    /**
     * Testa o endpoint para deletar uma tarefa pelo ID.
     * Verifica se a tarefa é deletada com sucesso.
     */
    @Test
    void testDeleteTarefa() throws Exception {
        mockMvc.perform(delete("/tasks/{id}", 1))
                .andExpect(status().isOk());
    }
}
