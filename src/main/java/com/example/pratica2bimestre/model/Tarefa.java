package com.example.pratica2bimestre.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Modelo representando uma tarefa.
 */
@Entity
@Getter
@Setter
@Schema(description = "Modelo representando uma tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da tarefa", example = "1")
    private Integer id;

    @Schema(description = "Título da tarefa", example = "Finalizar relatório")
    private String titulo;

    @Schema(description = "Descrição detalhada da tarefa", example = "Finalizar o relatório do segundo bimestre")
    private String descricao;

    @Schema(description = "Data de criação da tarefa", example = "2024-11-06T18:20:00")
    private LocalDateTime dataCriada = LocalDateTime.now();

    @Schema(description = "Status da tarefa", example = "A fazer")
    private String status = "A fazer";

    @Schema(description = "Prioridade da tarefa", example = "Alta")
    private String prioridade;

    @Schema(description = "Data limite para finalizar a tarefa", example = "2024-11-10T18:00:00")
    private Date dataFinal;
}
