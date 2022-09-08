package com.example.crudpacientes.models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "paciente")
public class Paciente {
    
    @NotEmpty
    @Getter @Setter private String nome;

    @Id
    @NotEmpty
    @Getter @Setter private String cpf;

    @NotEmpty
    @Getter @Setter private String sexo;

    @NotEmpty
    @Getter @Setter private String rua;

    @NotNull
    @Getter @Setter private Integer numero;

    @NotEmpty
    @Getter @Setter private String bairro;

    @NotEmpty
    @Getter @Setter private String cidade;

    @NotEmpty
    @Getter @Setter private String estado;

    @NotEmpty
    @Getter @Setter private String celular;

    @NotNull
    @Getter @Setter private Date dataNascimento; 

    @NotEmpty
    @Getter @Setter private String email;

    @NotEmpty
    @Getter @Setter private String motivoAvaliacao;

    @NotEmpty
    @Getter @Setter private String historiaDoencaAtual;

    @NotEmpty
    @Getter @Setter private String historiaMedicaPreg;

    @NotEmpty
    @Getter @Setter private String medicamentosUso;

    @NotEmpty
    @Getter @Setter private String historicoFamiliar;

    @NotEmpty
    @Getter @Setter private String observacoes;

}
