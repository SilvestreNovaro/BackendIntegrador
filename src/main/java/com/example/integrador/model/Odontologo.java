package com.example.integrador.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@NoArgsConstructor

@Entity
@Setter
@Getter
@Table(name = "ODONTOLOGOS")

public final class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private  String nombre;
    @Column
    private  String apellido;
    @Column
    private  String matricula;







}

