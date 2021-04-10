package com.example.xy.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

import com.example.xy.repositories.PoiRepository;



public class Proximity {
	
	private PoiRepository poiRepository;
	
	
	public Proximity(int dmax, int x, int y) {
		super();
		this.dmax = dmax;
		this.x = x;
		this.y = y;
	}
	
	
	public Proximity() {
		
	}
	
	@Min(value = 0, message = "The smallest accepted value for X coordinate is 0")
	@Column(name = "distance")
	private int dmax;	

	@Min(value = 0, message = "The smallest accepted value for X coordinate is 0")
	@Column(name = "x")
	private int x;
	
	@Min(value = 0, message = "The smallest accepted value for Y coordinate is 0") 
	@Column(name = "y")
	private int y;

	public int getDmax() {
		return dmax;
	}

	public void setDmax(int dmax) {
		this.dmax = dmax;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
