package com.example.bancopreguntasweb.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bancopreguntasweb.models.entities.Area;


@Repository("areaRepository")
public interface IAreaRepository extends JpaRepository<Area, Integer>{

}
