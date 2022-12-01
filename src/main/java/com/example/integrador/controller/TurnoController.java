package com.example.integrador.controller;

import com.example.integrador.model.Paciente;
import com.example.integrador.model.Turno;
import com.example.integrador.services.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@AllArgsConstructor
public class TurnoController {

    private  TurnoService service;

    @GetMapping("/turnos")
    public ResponseEntity<List<Turno>> listar(){return ResponseEntity.ok( service.listar());}


    @PostMapping("/nuevosTurnos")
    public ResponseEntity<Turno> agregar(@RequestBody Turno turno)  {
        try {
            service.agregar(turno);
            return new ResponseEntity<>(turno, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }}


    @PutMapping("/modificarTurno")
    public ResponseEntity<Turno> modificar(@RequestBody Turno turno){ return ResponseEntity.ok(service.modificar(turno));}


    @DeleteMapping("/eliminarTurno/{id}")

    public ResponseEntity<?> eliminarTurno (@PathVariable int id) {
        ResponseEntity response = null;
        if (service.getById(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            service.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }


    @GetMapping("/turnos/{id}")
    public ResponseEntity <Optional<Turno>>  getById(@PathVariable int id) {return ResponseEntity.ok(service.getById(id));}

}
