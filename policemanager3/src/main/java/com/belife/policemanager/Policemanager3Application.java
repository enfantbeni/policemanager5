package com.belife.policemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belife.policemanager.entity.Utilisateur;
import com.belife.policemanager.repository.UtilisateurRepository;


//@RestController
@SpringBootApplication
public class Policemanager3Application {
	
//	@Autowired
//	UtilisateurRepository utilisateurRepository;
//    @RequestMapping("/")
//    String home() {   	
//    Utilisateur util=new Utilisateur("Koudio Parfait","belife2019","Direection technique","Rajesiço",false);
//    	utilisateurRepository.save(util);
//    	
//    	return "Belife insurance";
//    }
   
   

	public static void main(String[] args) {
		SpringApplication.run(Policemanager3Application.class, args);
	}

}
