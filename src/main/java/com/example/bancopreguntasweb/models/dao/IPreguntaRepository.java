package com.example.bancopreguntasweb.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bancopreguntasweb.models.entities.Pregunta;



@Repository("preguntaRepository")
public interface IPreguntaRepository extends JpaRepository<Pregunta, Integer> {

}
