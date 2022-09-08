package com.example.crudpacientes.models;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Consulta {
    
    @NotEmpty
    private String motivoAvaliacao;

    @NotEmpty
    private String historiaDoencaAtual;

    @NotEmpty
    private String historiaMedicaPreg;

    @NotEmpty
    private String medicamentosUso;

    @NotEmpty
    private String historicoFamiliar;

    @NotEmpty
    private String observacoes;

    @OneToOne
    private Paciente paciente;
}
