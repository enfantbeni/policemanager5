package com.belife.policemanager.model.repository;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.belife.policemanager.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	@Query("select c from Client c where c.estSupprimer = :estSupprimer AND c.estSupprimer=false")
	List<Client> findAllClients(@Param("estSupprimer") Boolean estSupprimer);
																																																															
//	@Query("select c from Client c where c.genreAssure = :genreAssure AND c.nomAssure = :nomAssure AND c.nomClient = :nomClient AND c.matriculeClient = :matriculeClient AND c.numero = :numero AND c.periodicite = :periodicite AND c.couverture = :couverture AND c.prime = :prime AND c.datePrelevement = :datePrelevement AND c.dateSoumission = :dateSoumission AND c.dateNaissance = :dateNaissance AND c.profession = :profession AND c.employeur = :employeur AND c.ville = :ville AND  c.adressePostale = :adressePostale AND c.telephone1 = :telephone1 AND c.telephone2 = :telephone2 AND c.estSupprimer=false")
//	Client findClientByAllParam(@Param("estSupprimer") Boolean estSupprimer);
//	

}
																													
																																				
																																					