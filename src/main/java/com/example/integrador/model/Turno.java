package com.example.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Turnos")

public final class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"Turnos", "hibernateLazyInitializer"})
    private Odontologo odontologo;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false,  referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"Turnos", "hibernateLazyInitializer"})
    private Paciente paciente;
    @Column
    private LocalDate fecha;



}
