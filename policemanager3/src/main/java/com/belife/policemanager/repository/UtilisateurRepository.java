package com.belife.policemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.belife.policemanager.entity.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	
	@Query("select u from Utilisateur u where u.passwordUtilisateur = :password")
	Utilisateur findByPassword(@Param("password") String password);
	
	@Query("select u from Utilisateur u ")
	List<Utilisateur> findAllUtilisateur();
	
	

}
