package com.sfeir.shared;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class Region implements Serializable {
	
	@Id
	private Long id;
	private String name;
	private String[] departement;
	
	public Region() {
	}

	public Region(String name) {
		this.name = name;
	}
	
	public Region(String name, String[] departement) {
		this.name = name;
		this.departement = departement;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param nom the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the departement
	 */
	public String[] getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(String[] departement) {
		this.departement = departement;
	}
}
