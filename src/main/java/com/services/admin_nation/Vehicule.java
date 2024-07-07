package com.services.admin_nation;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Vehicule {
	@Id
	private String id;
	private String matricule;
	private String marque;
	private String proprietaire;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Vehicule(String id, String matricule, String marque, String proprietaire) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.proprietaire = proprietaire;
	}
	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
