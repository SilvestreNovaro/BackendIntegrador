package com.example.integrador.services;

import com.example.integrador.exceptions.OdontologoNotFound;
import com.example.integrador.exceptions.PacienteNotFound;
import com.example.integrador.model.Paciente;
import com.example.integrador.model.Turno;
import com.example.integrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurnoService {


    private TurnoRepository turnoRepository;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;


    public void agregar(Turno turno){
        if (turno.getOdontologo() != null && turno.getPaciente() != null){
            pacienteService.agregar(turno.getPaciente());
            odontologoService.agregar(turno.getOdontologo());}
        this.turnoRepository.save(turno);}





    public List<Turno> listar(){return turnoRepository.findAll();}

    public Turno modificar(Turno turno){return turnoRepository.save(turno);}

    public void eliminar(int id){turnoRepository.deleteById(id);}

    public Optional<Turno> getById(int id){return turnoRepository.findById(id);

    }


}
