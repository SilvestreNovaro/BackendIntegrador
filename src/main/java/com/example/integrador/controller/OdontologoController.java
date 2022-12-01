package com.example.integrador.controller;


import com.example.integrador.model.Odontologo;
import com.example.integrador.services.OdontologoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@AllArgsConstructor
public class OdontologoController {

    private final OdontologoService service;

    @GetMapping("/odontologos")
    public ResponseEntity<List<Odontologo>> listar(){return ResponseEntity.ok( service.listar());}


    @PostMapping("/nuevosOdontologos")
    public ResponseEntity<Odontologo> agregar(@RequestBody Odontologo odontologo)  {
        try {
            service.agregar(odontologo);
            return new ResponseEntity<>(odontologo, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }}


    @PutMapping("/modificarOdontologo")
    public ResponseEntity<Odontologo> modificar(@RequestBody Odontologo odontologo){ return ResponseEntity.ok(service.modificar(odontologo));}


    @DeleteMapping("/eliminarOdontologo/{id}")

    public ResponseEntity<?> eliminarOdontologo (@PathVariable int id) {
        ResponseEntity response = null;
        if (service.getByMatricula(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            service.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }


    @GetMapping("/odontologos/{id}")
    public ResponseEntity <Optional<Odontologo>>  getByMatricula(@PathVariable int id) {return ResponseEntity.ok(service.getByMatricula(id));}
}
