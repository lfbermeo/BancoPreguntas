package com.example.bancopreguntasweb.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bancopreguntasweb.models.entities.Carrera;
import com.example.bancopreguntasweb.models.entities.CarreraEntidad;


@Repository("carreraRepository")
public interface ICarreraRepository extends JpaRepository<Carrera, Integer> {

	@Query("select new com.example.bancopreguntasweb.models.entities.CarreraEntidad(idcarrera,nombre) from Carrera where area.idarea = :id")
	public List<CarreraEntidad> findByArea(@Param("id") int id);
}
