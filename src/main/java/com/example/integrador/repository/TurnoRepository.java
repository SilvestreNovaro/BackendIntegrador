package com.example.integrador.repository;

import com.example.integrador.model.Odontologo;
import com.example.integrador.model.Paciente;
import com.example.integrador.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TurnoRepository extends JpaRepository< Turno, Integer> {

}
