package com.example.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Setter
@Getter
@Table(name = "PACIENTES")

public final class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column
    private  String nombre;
    @Column
    private  String apellido;
    @Column
    private  String domicilio;
    @Column
    private  String dni;
    @Column
    private LocalDate fechaAlta;





}
