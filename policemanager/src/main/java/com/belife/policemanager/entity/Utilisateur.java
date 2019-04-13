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
@Column(name = "loginUtilisateur")
private String loginUtilisateur;
@Column(name = "fontion")
private String fonction;
@Column(name = "passwordUtilisateur")
private String passwordUtilisateur;
@Column(name = "estSupprime")
private Boolean estSupprime;

public Utilisateur(String nomEtPrenom, String loginUtilisateur, String fonction, String passwordUtilisateur,
		Boolean estSupprime) {
	super();
	this.nomEtPrenom = nomEtPrenom;
	this.loginUtilisateur = loginUtilisateur;
	this.fonction = fonction;
	this.passwordUtilisateur = passwordUtilisateur;
	this.estSupprime = estSupprime;
}

//Setters, getters and constructors
public Utilisateur() {
	super();
}

public Utilisateur(Integer idUtilisateur) {
    this.idUtilisateur = idUtilisateur;
}

public Utilisateur(String nomEtPrenom, String loginUtilisateur, String passwordUtilisateur, Boolean estSupprime) {
	super();
	this.nomEtPrenom = nomEtPrenom;
	this.loginUtilisateur = loginUtilisateur;
	this.passwordUtilisateur = passwordUtilisateur;
	this.estSupprime = estSupprime;
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
public String getLoginUtilisateur() {
    return loginUtilisateur;
}
public void setLoginUtilisateur(String loginUtilisateur) {
    this.loginUtilisateur = loginUtilisateur;
}

public String getPasswordUtilisateur() {
    return passwordUtilisateur;
}

public void setPasswordUtilisateur(String passwordUtilisateur) {
    this.passwordUtilisateur=passwordUtilisateur;
}
public Boolean getEstSupprime() {
    return estSupprime;
}
public void setEstSupprime(Boolean estSupprime) {
    this.estSupprime = estSupprime;
}

public String getFonction() {
	return fonction;
}

public void setFonction(String fonction) {
	this.fonction = fonction;
}








}
