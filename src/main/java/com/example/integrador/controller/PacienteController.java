package com.example.integrador.controller;


import com.example.integrador.model.Paciente;
import com.example.integrador.services.OdontologoService;
import com.example.integrador.services.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@AllArgsConstructor
public class PacienteController {

    private final PacienteService service;

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listar(){return ResponseEntity.ok( service.listar());}


    @PostMapping("/nuevosPacientes")
    public ResponseEntity<Paciente> agregar(@RequestBody Paciente paciente)  {
        try {
            service.agregar(paciente);
            return new ResponseEntity<>(paciente, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }}


    @PutMapping("/modificarPaciente")
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente paciente){ return ResponseEntity.ok(service.modificar(paciente));}


    @DeleteMapping("/eliminarPaciente/{id}")

    public ResponseEntity<?> eliminarPaciente (@PathVariable int id) {
        ResponseEntity response = null;
        if (service.getById(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            service.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }


    @GetMapping("/pacientes/{id}")
    public ResponseEntity <Optional<Paciente>>  getByMatricula(@PathVariable int id) {return ResponseEntity.ok(service.getById(id));}
}

