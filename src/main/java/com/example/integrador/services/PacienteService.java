package com.example.integrador.services;

import com.example.integrador.model.Odontologo;
import com.example.integrador.model.Paciente;
import com.example.integrador.repository.OdontologoRepository;
import com.example.integrador.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PacienteService {


    private PacienteRepository pacienteRepository;

    public void agregar(Paciente paciente){pacienteRepository.save(paciente);}
    public List<Paciente> listar(){return pacienteRepository.findAll();}

    public Paciente modificar(Paciente paciente){return pacienteRepository.save(paciente);}

    public void eliminar(int id){pacienteRepository.deleteById(id);}

    public Optional<Paciente> getById(int id){return pacienteRepository.findById(id);}


}
