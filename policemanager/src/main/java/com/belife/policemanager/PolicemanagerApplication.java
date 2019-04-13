package com.belife.policemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belife.policemanager.entity.Utilisateur;
import com.belife.policemanager.repository.UtilisateurRepository;


@RestController
@SpringBootApplication
public class PolicemanagerApplication {
	@Autowired
	UtilisateurRepository utilisateurRepository;
    @RequestMapping("/")
    String home() {   	
    Utilisateur util=new Utilisateur("Paul","belife885","Commercial","Marcel",false);
    	utilisateurRepository.save(util);
//    	save(new Utilisateur("Toto","belife125","Commercial","Commercial","Rajesh",false));
    	return "Belife insurance";
    }
   
   
   
	public static void main(String[] args) {
		SpringApplication.run(PolicemanagerApplication.class, args);
		
	}

}
