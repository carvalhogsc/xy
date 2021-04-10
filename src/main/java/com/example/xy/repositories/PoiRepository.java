package com.example.xy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.xy.models.Poi;

@Repository
public interface PoiRepository extends JpaRepository<Poi, Integer> {

}
