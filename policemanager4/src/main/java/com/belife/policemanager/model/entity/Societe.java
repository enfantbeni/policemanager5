package com.belife.policemanager.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "societe")
public class Societe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSocite;
	@Column(name = "codeSociete")
	private String codeSociete;
	@Column(name = "nomSociete")
	private String nomSociete;
	@Column(name = "dateCreation")
	private String dateCreation;
	@Column(name = "estSupprime", nullable=false)
	private Boolean estSupprimer;
	
	@ManyToOne
    @JoinColumn(name = "idClient")
    Client idClient;
	
	public Societe() {
		super();
	}
	
	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Integer getIdSocite() {
		return idSocite;
	}
	public void setIdSocite(Integer idSocite) {
		this.idSocite = idSocite;
	}
	public String getCodeSociete() {
		return codeSociete;
	}
	public void setCodeSociete(String codeSociete) {
		this.codeSociete = codeSociete;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	public Boolean getEstSupprimer() {
		return estSupprimer;
	}
	public void setEstSupprimer(Boolean estSupprimer) {
		this.estSupprimer = estSupprimer;
	}
	public Client getIdClient() {
		return idClient;
	}
	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}
	
	

}
