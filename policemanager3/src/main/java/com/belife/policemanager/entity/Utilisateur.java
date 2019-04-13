package com.belife.policemanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
private static final long serialVersionUID = -2343243243242432341L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer idUtilisateur;
@Column(name = "nomEtPrenom")
private String nomEtPrenom;
@Column(name = "identifiant")
private String identifiant;
@Column(name = "fontion")
private String fonction;
@Column(name = "password")
private String password;
@Column(name = "sexe")
private String sexe;
@Column(name = "estSupprime")
private String estSupprimer;


public Utilisateur(Integer idUtilisateur, String nomEtPrenom, String identifiant, String fonction,
		String password, String sexe, String estSupprimer) {
	super();
	this.idUtilisateur = idUtilisateur;
	this.nomEtPrenom = nomEtPrenom;
	this.identifiant = identifiant;
	this.fonction = fonction;
	this.password = password;
	this.estSupprimer = estSupprimer;
}
public Utilisateur(String nomEtPrenom, String identifiant, String fonction, String password,
		String estSupprimer) {
	super();
	this.nomEtPrenom = nomEtPrenom;
	this.identifiant = identifiant;
	this.fonction = fonction;
	this.password = password;
	this.estSupprimer = estSupprimer;
}

//Setters, getters and constructors
public Utilisateur() {
	super();
}

public Utilisateur(Integer idUtilisateur) {
    this.idUtilisateur = idUtilisateur;
}

public Utilisateur(String nomEtPrenom, String identifiant, String password, String estSupprimer) {
	super();
	this.nomEtPrenom = nomEtPrenom;
	this.identifiant = identifiant;
	this.password = password;
	this.estSupprimer = estSupprimer;
}
public Utilisateur(String nomEtPrenom, String password) {
	super();
	this.nomEtPrenom = nomEtPrenom;
	this.password = password;
}

public Integer getIdUtilisateur() {
    return idUtilisateur;
}
public void setIdUtilisateur(Integer idUtilisateur) {
    this.idUtilisateur = idUtilisateur;
}

public String getNomEtPrenom() {
    return nomEtPrenom;
}

public void setNomEtPrenom(String nomEtPrenom) {
    this.nomEtPrenom=nomEtPrenom;
}
public String getIdentifiant() {
	return identifiant;
}
public void setIdentifiant(String identifiant) {
	this.identifiant = identifiant;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
public String getEstSupprimer() {
	return estSupprimer;
}
public void setEstSupprimer(String estSupprimer) {
	this.estSupprimer = estSupprimer;
}
public String getFonction() {
	return fonction;
}

public void setFonction(String fonction) {
	this.fonction = fonction;
}

}
