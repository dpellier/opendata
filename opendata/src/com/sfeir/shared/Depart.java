package com.sfeir.shared;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class Depart implements Serializable {

	@Id
	private Long id;
	private String name;
	
	public Depart() {}
	
	public Depart( String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
