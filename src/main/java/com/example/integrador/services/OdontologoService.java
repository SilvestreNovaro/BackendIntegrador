package com.example.integrador.services;

import com.example.integrador.model.Odontologo;
import com.example.integrador.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OdontologoService {

    private OdontologoRepository odontologorepository;

    public void agregar(Odontologo odontologo){odontologorepository.save(odontologo);}
    public List<Odontologo> listar(){return odontologorepository.findAll();}

    public Odontologo modificar(Odontologo odontologo){return odontologorepository.save(odontologo);}

    public void eliminar(int id){odontologorepository.deleteById(id);}

    public Optional<Odontologo> getByMatricula(int id){return odontologorepository.findById(id);}


}
