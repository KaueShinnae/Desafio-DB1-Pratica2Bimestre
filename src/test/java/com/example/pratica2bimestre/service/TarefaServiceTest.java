package com.example.pratica2bimestre.service;

import com.example.pratica2bimestre.model.Tarefa;
import com.example.pratica2bimestre.repository.TarefaRepository;
import com.example.pratica2bimestre.service.TarefaFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Classe de teste para o serviço TarefaService.
 * Testa operações de adição, consulta, atualização e remoção de tarefas.
 */
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @Mock
    private TarefaFacade tarefaFacade;

    @InjectMocks
    private TarefaService tarefaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testa a adição de uma nova tarefa.
     * Verifica se a tarefa é salva corretamente no repositório.
     */
    @Test
    void testAddTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Nova Tarefa");

        when(tarefaFacade.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa result = tarefaService.addTarefa(tarefa);

        assertNotNull(result);
        assertEquals("Nova Tarefa", result.getTitulo());
    }

    /**
     * Testa a busca de uma tarefa pelo ID.
     * Verifica se a tarefa correta é retornada quando um ID válido é fornecido.
     */
    @Test
    void testGetTarefaById() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1);
        tarefa.setTitulo("Teste Tarefa");

        when(tarefaFacade.findById(1)).thenReturn(Optional.of(tarefa));

        Tarefa result = tarefaService.getTarefaById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Teste Tarefa", result.getTitulo());
    }

    /**
     * Testa a atualização de uma tarefa existente.
     * Verifica se as informações da tarefa são atualizadas corretamente.
     */
    @Test
    void testUpdateTarefa() {
        Tarefa tarefaExistente = new Tarefa();
        tarefaExistente.setId(1);
        tarefaExistente.setTitulo("Tarefa Antiga");

        Tarefa tarefaAtualizada = new Tarefa();
        tarefaAtualizada.setTitulo("Tarefa Atualizada");

        when(tarefaFacade.findById(1)).thenReturn(Optional.of(tarefaExistente));
        when(tarefaFacade.save(any(Tarefa.class))).thenReturn(tarefaAtualizada);

        Tarefa result = tarefaService.updateTarefa(1, tarefaAtualizada);

        assertNotNull(result);
        assertEquals("Tarefa Atualizada", result.getTitulo());
    }

    /**
     * Testa a remoção de uma tarefa pelo ID.
     * Verifica se o método de exclusão é chamado no repositório.
     */
    @Test
    void testDeleteTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1);

        when(tarefaFacade.findById(1)).thenReturn(Optional.of(tarefa));
        doNothing().when(tarefaFacade).delete(tarefa);

        assertDoesNotThrow(() -> tarefaService.deleteTarefa(1));
        verify(tarefaFacade, times(1)).delete(tarefa);
    }
}
