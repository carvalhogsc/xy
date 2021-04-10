package com.example.xy.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xy.models.Poi;
import com.example.xy.models.Proximity;
import com.example.xy.repositories.PoiRepository;


@RestController
@RequestMapping(path = "/proximity")
public class ProximityResource {

	private PoiRepository poiRepository;

	public ProximityResource(PoiRepository poiRepository) {
		super();
		this.poiRepository = poiRepository;
	}
	
	@PostMapping
	public ResponseEntity<List<Poi>> postController(@Valid @RequestBody Proximity proximity){
		List<Poi> proximityPois = new ArrayList<>();
		proximityPois = poiRepository
		.findAll()
		.stream()
		.filter(item -> Math.hypot((item.getX() - proximity.getX()), (item.getY() - proximity.getY()))
				<= proximity.getDmax())
		.collect(Collectors.toList());
		return new ResponseEntity<>(proximityPois, HttpStatus.OK);
	}
	
}
