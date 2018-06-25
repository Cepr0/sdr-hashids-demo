package io.github.cepr0.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Model {
	
	@Id @GeneratedValue private Long id;
	private String name;
	
	public Model() {
	}
	
	public Model(String name) {
		this.name = name;
	}
}
