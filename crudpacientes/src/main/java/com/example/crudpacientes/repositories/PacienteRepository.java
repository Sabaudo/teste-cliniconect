package com.example.crudpacientes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.crudpacientes.models.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long>{
    Paciente findByNome(String nome);
    Paciente findByEmail(String nome);
    Paciente findByCpf(String nome);
}
