package com.example.xy.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xy.models.Poi;
import com.example.xy.repositories.PoiRepository;


@RestController
@RequestMapping(path = "/pois")
public class PoiResource {
	
	private PoiRepository poiRepository;

	public PoiResource(PoiRepository poiRepository) {
		super();
		this.poiRepository = poiRepository;
	}
	
	@PostMapping
	public ResponseEntity<Poi> save(@Valid @RequestBody Poi poi){
		poiRepository.save(poi);
		return new ResponseEntity<Poi>(poi, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Poi>> getAll(){
		List<Poi> poi = new ArrayList<>();
		poi = poiRepository.findAll();
		return new ResponseEntity<>(poi, HttpStatus.OK);
	}
	
}
