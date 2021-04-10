package com.example.xy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



@Entity
public class Poi {
	
	@GeneratedValue
	@Id
	private int id;
	
	@NotEmpty(message = "Name may not be empty")
	@Column(name = "name")
	private String name;
	
	@Min(value = 0, message = "The smallest accepted value for X coordinate is 0")
	@Column(name = "x")
	private int x;
	
	@Min(value = 0, message = "The smallest accepted value for Y coordinate is 0") 
	@Column(name = "y")
	private int y;
	
	public Poi() {

	}	
	
	public Poi(String name, int x, int y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Poi [name=" + name + ", x=" + x + ", y=" + y + "]";
	}
	
	
}
