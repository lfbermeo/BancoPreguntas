package com.example.bancopreguntasweb.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bancopreguntasweb.models.entities.Respuestas;



@Repository("respuestasRepository")
public interface IRespuestasRepository extends JpaRepository<Respuestas, Integer> {

}
