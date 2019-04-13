package com.belife.policemanager.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.belife.policemanager.entity.Utilisateur;
import com.belife.policemanager.repository.UtilisateurRepository;

@Controller
public class UtilisateurController {
	private String commercial="Commercial";
	private String directionTechnique="Technicien";
	private String administrateur="Administrateur";
	private String passwordAffiche=null;
	// Injecter via application.properties
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
	
	 @Autowired
     UtilisateurRepository utilisateurRepository;  
	 
	 
	@RequestMapping(value = {"/" }, method = RequestMethod.GET)
    public String index(Model model) {    
        return "redirect:/authentification";
    }
	@RequestMapping(value = {"/authentification" }, method = RequestMethod.GET)
    public String authentification(Model model) {    
        return "authentification";
    }
	@RequestMapping(value = {"/inscriptionUtil" }, method = RequestMethod.GET)
    public String inscriptionUtil(Model model) {    
        return "inscriptionUtilisateur";
    }
	@RequestMapping(value = {"/inscriptionUtilisateur" }, method = RequestMethod.POST)
    public String inscriptionUtilisateur(Model model,@ModelAttribute("utilisateur") Utilisateur utilisateur) { 
		String password=utilisateur.getPassword().trim();	
		System.out.println(" Mot de passe "+password);
		Utilisateur utilisateurSave=null;
		utilisateurSave=utilisateurRepository.findByPassword(password);		
		if(utilisateurSave==null) {
		utilisateurRepository.save(utilisateur);
		}
		List<Utilisateur> utilisateurs=new ArrayList<Utilisateur>();
		utilisateurs=utilisateurRepository.findAllUtilisateur();
		System.out.println("Objet utilisateur  "+utilisateurs);
		model.addAttribute("utilisateurs", utilisateurs);
        return "inscriptionUtilisateur";
    }
	
	@RequestMapping(value = {"/updateUtilisateur" }, method = RequestMethod.POST)
    public String updateUtilisateur(Model model,@ModelAttribute("utilisateur") Utilisateur utilisateur) { 
		String password=utilisateur.getPassword().trim();		
		Utilisateur utilisateurSave=null;
		utilisateurSave=utilisateurRepository.findByPassword(password);		
		if(utilisateurSave==null) {
		utilisateurRepository.save(utilisateur);
		}
        return "inscriptionUtilisateur";
    }
	
	@RequestMapping(value = { "/utilisateurListe" }, method = RequestMethod.GET)
    public String savePerson(Model model, @ModelAttribute("utilisateur") Utilisateur utilisateur) {
		String nomEtPrenom = utilisateur.getNomEtPrenom();
        String password = utilisateur.getPassword();
        model.addAttribute("errorMessage", errorMessage);
        	Utilisateur utilisateurRepo=utilisateurRepository.findByPassword(password);
        	
//        		String nomPrenomMonsieur=utilisateurRepo.getNomEtPrenom();
//        		Integer id=utilisateurRepo.getIdUtilisateur();
//        		String nomPrenom=utilisateurRepo.getNomEtPrenom();
//        		String passwordUtil=utilisateurRepo.getPasswordUtilisateur();
//        		String fonction=utilisateurRepo.getFonction();
//        		String login=utilisateurRepo.getLoginUtilisateur(); 
//        		Boolean estSupprime=utilisateurRepo.getEstSupprime();
//        	Utilisateur utilisateurs =new Utilisateur(nomEtPrenom, password);
//        	Utilisateur utilisateurP=new Utilisateur(id,nomPrenom,login,fonction,passwordUtil,estSupprime);
//        	model.addAttribute("nomPrenomMonsieur", nomPrenomMonsieur);
//        	model.addAttribute("utilisateurP",utilisateurP);
        	
            return "utilisateurListe";         	
    }
	
	@RequestMapping(value = "/accueilCommercial" , method = RequestMethod.GET)
	public String accueilCommercial(Model model, HttpSession session,@ModelAttribute( "utilisateur") Utilisateur u) {
		String password=(String) session.getAttribute("passwordSessionCom");
		System. out.println("Mot de passe : "+password);
		String nom=u.getNomEtPrenom();
		String pa=passwordAffiche;
		Utilisateur utilisateurRepo=utilisateurRepository.findByPassword(password);
		model.addAttribute("nomPrenomMonsieurCom",pa);
		System.out.println("Mot de passe essai : "+ pa);
		return "accueilCommercial";
	 }
	@RequestMapping(value = "/accueilAdministrateur" , method = RequestMethod.GET)
	public String accueilAdministrateur(Model model, HttpSession session,@ModelAttribute("utilisateurSession") Utilisateur u) {
		String password=(String) session.getAttribute("passwordSessionAdmin");
		System. out.println("Mot de passe : "+password);
		Utilisateur utilisateurRepo=utilisateurRepository.findByPassword(password);
		model.addAttribute("nomPrenomMonsieurAdmin",utilisateurRepo.getNomEtPrenom());
		return "accueilAdministrateur";
	 }
	@RequestMapping(value = "/accueilTechnicien" , method = RequestMethod.GET)
	public String accueilTechnicien(Model model, HttpSession session,@ModelAttribute("utilisateurSession") Utilisateur u) {
		String password=(String) session.getAttribute("passwordSessionTech");
		System. out.println("Mot de passe : "+password);
		Utilisateur utilisateurRepo=utilisateurRepository.findByPassword(password);
		model.addAttribute("nomPrenomMonsieurTech",utilisateurRepo.getNomEtPrenom());
		return "accueilTechnicien";
	 }
	
	@RequestMapping(value = {"/accueil" }, method = RequestMethod.POST)
    public String accueil(Model model, HttpSession session,@ModelAttribute("utilisateur") Utilisateur utilisateur) {       
		String nomEtPrenom = utilisateur.getNomEtPrenom();
        String password = utilisateur.getPassword();
        model.addAttribute("errorMessage", errorMessage);
        if (nomEtPrenom != null && nomEtPrenom.length() > 0  && password != null && password.length() > 0) {
        	Utilisateur utilisateurRepo=utilisateurRepository.findByPassword(password);
//        	System.out.println(" password "+utilisateurRepo.getPasswordUtilisateur());
        	if(utilisateurRepo != null) {
        		model.addAttribute("utiliusateur", utilisateurRepo);
        		String passwordSession=password;
        		passwordAffiche=password;
        		System.out.println(" Password à afficher "+passwordAffiche);
        		String nomPrenomMonsieur=utilisateurRepo.getNomEtPrenom();
        		String fonction=utilisateurRepo.getFonction().trim();     		
        		model.addAttribute("nomPrenomMonsieur", nomPrenomMonsieur);
        	  if(fonction.equals(commercial)) {
        		  String essai="Bonjour";
        		  model.addAttribute("essai",essai);
        		  session.setAttribute( "passwordSessionCom", passwordSession);
        		  return "redirect:/accueilCommercial";    		 
        	  }
        	  else if(fonction.equals(directionTechnique)) {
        		  session.setAttribute( "passwordSessionTech", utilisateurRepo);
        		  return "redirect:/accueilTechnicien";
        	  }      
        	  else if(fonction.equals(administrateur)) {
        		  session.setAttribute( "utilisateurSessionAdmin", utilisateurRepo);
        		  return "redirect:/accueilAdministrateur";
        	  }
            }           
            return "redirect:/";
        }       
       return "redirect:/";		
    }
	
	
	
	
//	@RequestMapping(value = {"/verificationForm" }, method = RequestMethod.POST)
//    public String verificationForm(Model mode) {
//        mode.addAttribute("message", message);
//       	
//        Utilisateur util=new Utilisateur("Yannick","belife2018","Administrateur","Roiladhj",false);
//        	utilisateurRepository.save(util);        
//        return "verificationForm";
//    }
	
	
	
	
}
