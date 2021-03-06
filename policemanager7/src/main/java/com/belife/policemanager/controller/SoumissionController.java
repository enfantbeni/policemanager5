package com.belife.policemanager.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.belife.policemanager.model.dto.BanqueDto;
import com.belife.policemanager.model.dto.ClientDto;
import com.belife.policemanager.model.dto.SourcePrelevementDto;
import com.belife.policemanager.model.entity.Agence;
import com.belife.policemanager.model.entity.Agent;
import com.belife.policemanager.model.entity.Banque;
import com.belife.policemanager.model.entity.BanquePrincipale;
import com.belife.policemanager.model.entity.Client;
import com.belife.policemanager.model.entity.ClientBanque;
import com.belife.policemanager.model.entity.ClientPlan;
import com.belife.policemanager.model.entity.Plan;
import com.belife.policemanager.model.entity.Utilisateur;
import com.belife.policemanager.model.repository.AgentRepository;
import com.belife.policemanager.model.repository.BanquePrincipaleRepository;
import com.belife.policemanager.model.repository.BanqueRepository;
import com.belife.policemanager.model.repository.ClientBanqueRepository;
import com.belife.policemanager.model.repository.ClientPlanRepository;
import com.belife.policemanager.model.repository.ClientRepository;
import com.belife.policemanager.model.repository.PlanRepository;
import com.belife.policemanager.model.repository.RolesRepository;
import com.belife.policemanager.model.repository.SocieteRepository;
import com.belife.policemanager.model.repository.SourcePoliceRepository;
import com.belife.policemanager.model.repository.UtilisateurRepository;



@Controller
public class SoumissionController {
	 @Autowired
     UtilisateurRepository utilisateurRepository; 
	 
	 @Autowired
     RolesRepository rolesRepository;
	 
	 @Autowired
     SourcePoliceRepository sourcePoliceRepository;
	 
	 @Autowired
     BanqueRepository banqueRepository;
	 
	 @Autowired
     BanquePrincipaleRepository banquePrincipaleRepository;
	 
	 @Autowired
     SocieteRepository societeRepository;
	 
	 @Autowired
     PlanRepository planRepository;
	 
	 @Autowired
     ClientRepository clientRepository;
	 
	 @Autowired
     AgentRepository agentRepository;
	 
	 @Autowired
     ClientPlanRepository clientPlanRepository;
	 
	 @Autowired
     ClientBanqueRepository clientBanqueRepository;
	 
	 
	 
	 
	public SoumissionController () {
		
	}
	 
	 
    private String identifiantSession=null;
    SourcePrelevementDto sourceDto=new  SourcePrelevementDto();
    
    
	@RequestMapping(value = {"/soumission" }, method = RequestMethod.GET)
    public String sourcePrelevement(Model model,  HttpSession session) { 		
		String resultat=null;
		try {
			identifiantSession=session.getAttribute("identifiantSession").toString().trim();
		}
		catch(Exception e) {
			resultat="pageErreur";
			return resultat;
		}
		
		

		model.addAttribute("cheminAccueil",  "Accueil >");
		model.addAttribute("cheminSoumission",  "Soumission >");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("choisirSourcePrelevement", "choisirSourcePrelevement");
		model.addAttribute("titre", " Soumission de Proposition");
		model.addAttribute("menuNavigation", "menuNavigation");
        return "utilisateur/accueilUtilisateur";
    }
	
	
	
//	@@ designe par
	
	@RequestMapping(value = {"/soumissionProposition@@Individuel" }, method = RequestMethod.POST)
    public String soumissionPropositionDeux(Model model, @ModelAttribute("banqueDto") BanqueDto banqueDto, HttpSession session, @PageableDefault(size = 10) Pageable pageable, HttpServletRequest request) { 		
		String resultat=null;
		String genreConvention=null;
		String nomSource=null;
		try {
			identifiantSession=session.getAttribute("identifiantSession").toString().trim();
		}
		catch(Exception e) {
			resultat="pageErreur";
			return resultat;
		}
		
		 
		 int page = 0;
		 int size = 10;
		 if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
	            page = Integer.parseInt(request.getParameter("page")) - 1;
	        }
		 if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
	            size = Integer.parseInt(request.getParameter("size"));
	        }
		 Boolean estSupprimer=false;
		 model.addAttribute("clientsPage", clientRepository.findAll(PageRequest.of(page, size)));
		 
		
		List<String> nomSources=societeRepository.findAllNomSociete(estSupprimer);
		model.addAttribute("nomSources",  nomSources);
		String nomGuichet=banqueDto.getNomGuichet().trim();
		nomSource=session.getAttribute("nomSourceCache").toString().trim();
		model.addAttribute("nomSource",  nomSource);
		
		model.addAttribute("testIndividuel", "testIndividuel");
		
		
		///////////////////////// 	//////////////////// Données à soumettre
		session.setAttribute("nomGuichetSoumis", nomGuichet);
		session.setAttribute("nomBanqueSoumis", nomSource);
		String nomGuichetSoumis=session.getAttribute("nomGuichetSoumis").toString().trim();
		String nomBanqueSoumis=session.getAttribute("nomBanqueSoumis").toString().trim();
		String codeGuichetSoumis=banqueRepository.findCodeGuichetByNomGuichet(nomGuichetSoumis);
		String codeBanqueSoumis=banquePrincipaleRepository.findCodeBanquePrincipale(nomBanqueSoumis);
		String police=codeGuichetSoumis.concat(codeBanqueSoumis);
		session.setAttribute("police", police);
		model.addAttribute("police",police);
		System.out.println("   Police   :  "+police);
				
		
		
	
//		Code Banque et code Guichet
		String codeBanquePrincipale=banquePrincipaleRepository.findCodeBanquePrincipale(nomSource);
		String codeGuichet=banqueRepository.findCodeGuichetByNomGuichet(nomGuichet);
		model.addAttribute("genreSource", " Numero Compte * : ");
		
		String identifiant=session.getAttribute("identifiantSession").toString().trim();
		Utilisateur utilisateurRep=utilisateurRepository.findByIdentifiant(identifiant);
		Agence agence=utilisateurRep.getIdAgence();
		Integer idAgence=agence.getIdAgence();
		List<String> codeAgents=agentRepository.findAllCodeAgents(agence);
		model.addAttribute("codeAgents", codeAgents);
		List<Client> soumissions=clientRepository.findAllClients(estSupprimer);
		model.addAttribute("soumissions", soumissions);
		model.addAttribute("listeSoumission", "listeSoumission");
		List<String> planDurees=planRepository.findPlanDurees();
		model.addAttribute("cheminAccueil",  "Accueil >");
		model.addAttribute("cheminSoumission",  "Soumission >");
		model.addAttribute("planDurees", planDurees);
		model.addAttribute("nomSource",  nomSource);
		model.addAttribute("genreConvention",  genreConvention);
		model.addAttribute("titre", " Soumission de Proposition");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("soumissionProposition", "soumissionProposition");
		model.addAttribute("menuNavigation", "menuNavigation");
		model.addAttribute("police",police);
        return "utilisateur/accueilUtilisateur";
    }
	
	
	@RequestMapping(value = {"/soumissionProposition" }, method = RequestMethod.POST)
    public String soumissionProposition(Model model, @ModelAttribute("sourceDto") SourcePrelevementDto sourceDto, HttpSession session, @PageableDefault(size = 10) Pageable pageable, HttpServletRequest request) { 		
		String resultat=null;
		String genreConvention=null;
		String nomSource=null;
		try {
			identifiantSession=session.getAttribute("identifiantSession").toString().trim();
		}
		catch(Exception e) {
			resultat="pageErreur";
			return resultat;
		}
		 try {
			  genreConvention=session.getAttribute("genreConvention").toString().trim(); 
			  nomSource=sourceDto.getNomSource().trim();
		 }catch(Exception e) {
			 List<String> planDurees=planRepository.findPlanDurees();
				model.addAttribute("planDurees", planDurees);
				
				model.addAttribute("cheminAccueil",  "Accueil >");
				model.addAttribute("cheminSoumission",  "Soumission >");
				model.addAttribute("erreurConvention",  "  Veillez choisir la nature de la convention ");
				model.addAttribute("genreConvention",  genreConvention);
				model.addAttribute("titre", " Soumission de Proposition");
				model.addAttribute("identifiantSession", identifiantSession);
				model.addAttribute("choisirSourcePrelevement", "choisirSourcePrelevement");
				model.addAttribute("menuNavigation", "menuNavigation");
		        return "utilisateur/accueilUtilisateur";			 
		 }
		 
		 int page = 0;
		 int size = 10;
		 if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
	            page = Integer.parseInt(request.getParameter("page")) - 1;
	        }
		 if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
	            size = Integer.parseInt(request.getParameter("size"));
	        }
		 Boolean estSupprimer=false;
		 model.addAttribute("clientsPage", clientRepository.findAll(PageRequest.of(page, size)));
		 
		session.setAttribute("codeSocieteSoumis", nomSource);	
		String codeSocieteSoumis=session.getAttribute("codeSocieteSoumis").toString().trim();
		codeSocieteSoumis=societeRepository.findCodeSocieteByNomSociete(codeSocieteSoumis);
		model.addAttribute("police", codeSocieteSoumis);
		
		String genreGroupe="groupe";
		String genreIndividuel="individuel";
		List<String> nomSources=societeRepository.findAllNomSociete(estSupprimer);
		model.addAttribute("nomSources",  nomSources);
		
		String redirectionChoixGuichet=session.getAttribute("redirectionChoixGuichet").toString().trim();
		String choixGuichetBanque="choixGuichet";
		if(redirectionChoixGuichet.equals(choixGuichetBanque)) {
			session.setAttribute("nomSourceCache",nomSource);
			return "redirect:/redirectionChoixGuichet";
		}
			
		if(genreConvention.equals(genreGroupe)) {
			model.addAttribute("genreSource", " Matricule Client * : ");
			model.addAttribute("testGroupe", "testGroupe");
		}	
		String identifiant=session.getAttribute("identifiantSession").toString().trim();
		Utilisateur utilisateurRep=utilisateurRepository.findByIdentifiant(identifiant);
		Agence agence=utilisateurRep.getIdAgence();
		Integer idAgence=agence.getIdAgence();
		List<String> codeAgents=agentRepository.findAllCodeAgents(agence);
		model.addAttribute("codeAgents", codeAgents);
		List<Client> soumissions=clientRepository.findAllClients(estSupprimer);
		model.addAttribute("soumissions", soumissions);
		model.addAttribute("listeSoumission", "listeSoumission");
		session.setAttribute("nomSourceCache",nomSource);
//		/////////////////// Code Société Soumis
		String codeSociete=societeRepository.findCodeSocieteByNomSociete(nomSource);
		session.setAttribute("codeSocieteSoumis",codeSociete);
		
		List<String> planDurees=planRepository.findPlanDurees();
		model.addAttribute("cheminAccueil",  "Accueil >");
		model.addAttribute("cheminSoumission",  "Soumission >");
		model.addAttribute("planDurees", planDurees);
		model.addAttribute("nomSource",  nomSource);
		model.addAttribute("genreConvention",  genreConvention);
		model.addAttribute("titre", " Soumission de Proposition");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("soumissionProposition", "soumissionProposition");
		model.addAttribute("menuNavigation", "menuNavigation");
        return "utilisateur/accueilUtilisateur";
    }
	
	@RequestMapping(value = {"/redirectionChoixGuichet" }, method = RequestMethod.GET)
    public String redirectionChoixGuichet(Model model,  HttpSession session) { 		
		String resultat=null;
		try {
			identifiantSession=session.getAttribute("identifiantSession").toString().trim();
		}
		catch(Exception e) {
			resultat="pageErreur";
			return resultat;
		}
		String nomBanque=session.getAttribute("nomSourceCache").toString().trim();		
		BanquePrincipale banquePrincipale=banquePrincipaleRepository.findBanquePrincipaleByNom(nomBanque);
		List<String> nomGuichets=banqueRepository.findNomGuichets(banquePrincipale);
		
		model.addAttribute("nomGuichets", nomGuichets);
		model.addAttribute("cheminAccueil",  "Accueil >");
		model.addAttribute("cheminSoumission",  "Soumission >");
		model.addAttribute("cheminAccueil",  "Accueil >");
		model.addAttribute("cheminSoumission",  "Soumission >");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("choisirGuichetBanque", "choisirGuichetBanque");
		model.addAttribute("titre", " Soumission de Proposition");
		model.addAttribute("menuNavigation", "menuNavigation");
        return "utilisateur/accueilUtilisateur";
    }
	
	@RequestMapping(value = {"/envoiCacheGenre" }, method = RequestMethod.POST)
    public String envoiCacheGenre(Model model, @ModelAttribute("sourceDto") SourcePrelevementDto sourceDto, HttpSession session) { 		
		String resultat=null;
		try {
			identifiantSession=session.getAttribute("identifiantSession").toString().trim();
		}
		catch(Exception e) {
			resultat="pageErreur";
			return resultat;
		}
		String genreGroupe="groupe";
		String genreIndividuel="individuel";
		String nomGenre=sourceDto.getNomSource().trim();
		String genreConvention=sourceDto.getGenreConvention().trim();
		Boolean checkedGroupe=false;
		Boolean checkedIndividuel=false;
		String choixGuichet=null;
		
		
		if(nomGenre.equals(genreGroupe)) {
			checkedGroupe=true;
			Boolean estSupprimer=false;
			choixGuichet="pasBon";
			List<String> nomSources=societeRepository.findAllNomSociete(estSupprimer);
			model.addAttribute("checkedGroupe", checkedGroupe);
			model.addAttribute("nomSociete","Nom Société : ");
			model.addAttribute("nomSources", nomSources);
			session.setAttribute("redirectionChoixGuichet", choixGuichet);
			
		}
		if(nomGenre.equals(genreIndividuel)) {
			checkedIndividuel=true;
			Boolean estSupprimer=false;
			choixGuichet="choixGuichet";
			List<String> nomBanques=banquePrincipaleRepository.findNomsBanquePrincipale(estSupprimer);
			model.addAttribute("nomBanquePrincipales", "nomBanquePrincipales");
			model.addAttribute("checkedIndividuel", checkedIndividuel);
			model.addAttribute("nomBanques", nomBanques);
			session.setAttribute("redirectionChoixGuichet", choixGuichet);		
		}	
		
		session.setAttribute("genreConvention",genreConvention);
		model.addAttribute("cheminAccueil",  "Accueil >");
		model.addAttribute("cheminSoumission",  "Soumission >");
		model.addAttribute("choisirSourcePrelevement", "choisirSourcePrelevement");
		model.addAttribute("titre", " Soumission de Proposition");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("menuNavigation", "menuNavigation");
        return "utilisateur/accueilUtilisateur";
    }
	
	@RequestMapping(value = {"/confirmationSoumission" } , method = RequestMethod.POST)
    public String confirmationSoumission(Model model, @ModelAttribute("clientDto") ClientDto clientDto ,HttpSession session, HttpServletRequest request) { 
	 
	 String resultat=null;
		try {
			identifiantSession=session.getAttribute("identifiantSession").toString().trim();
		}
		catch(Exception e) {
			resultat="pageErreur";
			return resultat;
		}
		
		String planDuree=clientDto.getPlanDuree().trim();
		String nomAssure=clientDto.getNomAssure().trim();
		String nomClient=clientDto.getNomClient().trim();
		String numero=clientDto.getNumero().trim();
		String periodicite=clientDto.getPeriodicite().trim();
		Long couverture=clientDto.getCouverture();
		String genreAssure=clientDto.getGenreAssure().trim();
		Long prime=clientDto.getPrime();
		String datePrelevement=clientDto.getDatePrelevement();
		String dateSoumission=clientDto.getDateSoumission();	
		String dateNaissance=clientDto.getDateNaissance();
		String matriculeClient=clientDto.getMatriculeClient();
		String banque=clientDto.getBanque().trim();
		String profession=clientDto.getProfession().trim();
		String employeur=clientDto.getEmployeur().trim();
		String ville=clientDto.getVille().trim();
		String adressePostal=clientDto.getAdressPostal().trim();
		String codeAgent=clientDto.getCodeAgent().trim();
		String telephone1=clientDto.getTelephone1().trim();
		String telephone2=clientDto.getTelephone2().trim();	
		String nomComPreContrat=clientDto.getNomComPreContrat().trim();
		
		String police=session.getAttribute("police").toString().trim();
		police=police.concat(numero);
		model.addAttribute("police", police);
		session.setAttribute("police", police);
			
		session.setAttribute("planDuree", planDuree);
		session.setAttribute("nomAssure", nomAssure);
		session.setAttribute("genreAssure", genreAssure);
		session.setAttribute("nomClient", nomClient);
		session.setAttribute("numero", numero);
		session.setAttribute("periodicite", periodicite);
		session.setAttribute("couverture", couverture);
		session.setAttribute("prime", prime);
		session.setAttribute("datePrelevement", datePrelevement);
		session.setAttribute("dateSoumission", dateSoumission);
		session.setAttribute("dateNaissance", dateNaissance);
		session.setAttribute("matriculeClient", matriculeClient);
		session.setAttribute("banque", banque);
		session.setAttribute("profession", profession);
		session.setAttribute("employeur", employeur);
		session.setAttribute("ville", ville);
		session.setAttribute("adressPostal", adressePostal);
		session.setAttribute("codeAgent", codeAgent);
		session.setAttribute("telephone1", telephone1);
		session.setAttribute("telephone2", telephone2);
		session.setAttribute("nomComPreContrat", nomComPreContrat);
		
		String nomSource=session.getAttribute("nomSourceCache").toString().trim();
		model.addAttribute("cheminAccueil",  "Accueil >");
		model.addAttribute("cheminSoumission",  "Soumission >");
		model.addAttribute("planDuree", planDuree);
		model.addAttribute("nomAssure", nomAssure);
		model.addAttribute("genreAssure", genreAssure);
		model.addAttribute("nomClient", nomClient);
		model.addAttribute("nomSource", nomSource);
		model.addAttribute("numero", numero);
		model.addAttribute("periodicite", periodicite);
		model.addAttribute("couverture", couverture);
		model.addAttribute("prime", prime);
		model.addAttribute("matriculeClient", matriculeClient);
		model.addAttribute("datePrelevement", datePrelevement);		
		model.addAttribute("dateSoumission", dateSoumission);
		model.addAttribute("dateSoumission", dateSoumission);
		model.addAttribute("dateNaissance", dateNaissance);
		model.addAttribute("banque", banque);
		model.addAttribute("profession", profession);
		model.addAttribute("employeur", employeur);
		model.addAttribute("ville", ville);
		model.addAttribute("adressPostal", adressePostal);	
		model.addAttribute("codeAgent", codeAgent);
		model.addAttribute("telephone1", telephone1);
		model.addAttribute("telephone2", telephone2);
		model.addAttribute("nomComPreContrat", nomComPreContrat);
		
		 int page = 0;
		 int size = 10;
		 if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
	            page = Integer.parseInt(request.getParameter("page")) - 1;
	        }
		 if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
	            size = Integer.parseInt(request.getParameter("size"));
	        }
		 model.addAttribute("clientsPage", clientRepository.findAll(PageRequest.of(page, size)));
		
		
		model.addAttribute("confirmationDonneeSoumission", "confirmationDonneeSoumission");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("titre", " Soumission de Proposition");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("menuNavigation", "menuNavigation");
        return "utilisateur/accueilUtilisateur";
    }
	
	@RequestMapping(value = {"/resultatAjoutProposition" } , method = RequestMethod.POST)
    public String resultaAjoutProposition(Model model, @ModelAttribute("client") Client client , @ModelAttribute("clientPlan") ClientPlan clientPlan , @ModelAttribute("clientBanque") ClientBanque clientBanque ,HttpSession session, HttpServletRequest request) { 
	 
		String resultat=null;
		try {
			identifiantSession=session.getAttribute("identifiantSession").toString().trim();
		}
		catch(Exception e) {
			resultat="pageErreur";
			return resultat;
		}
		
		String planDuree=session.getAttribute("planDuree").toString().trim();
		
		String nomAssure=session.getAttribute("nomAssure").toString().trim();
		String nomClient=session.getAttribute("nomClient").toString().trim();
		String numero=session.getAttribute("numero").toString().trim();
		String periodicite=session.getAttribute("periodicite").toString().trim();
		Long couverture=(Long) session.getAttribute("couverture");
		String genreAssure=session.getAttribute("genreAssure").toString().trim();
		Long prime=(Long) session.getAttribute("prime");
		String datePrelevement=session.getAttribute("datePrelevement").toString().trim();
		String dateSoumission=session.getAttribute("dateSoumission").toString().trim();	
		String dateNaissance=session.getAttribute("dateNaissance").toString().trim();
		String matriculeClient=session.getAttribute("matriculeClient").toString().trim();
		String banque=session.getAttribute("banque").toString().trim();
		String profession=session.getAttribute("profession").toString().trim();
		String employeur=session.getAttribute("employeur").toString().trim();
		String ville=session.getAttribute("ville").toString().trim();
		String adressePostal=session.getAttribute("adressPostal").toString().trim();
		String codeAgent=session.getAttribute("codeAgent").toString().trim();
		String telephone1=session.getAttribute("telephone1").toString().trim();
		String telephone2=session.getAttribute("telephone2").toString().trim();	
		String nomComPreContrat=session.getAttribute("nomComPreContrat").toString().trim();
		String nomSource=session.getAttribute("nomSourceCache").toString().trim();
		
		int page = 0;
		 int size = 10;
		 if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
	            page = Integer.parseInt(request.getParameter("page")) - 1;
	        }
		 if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
	            size = Integer.parseInt(request.getParameter("size"));
	        }
		 model.addAttribute("clientsPage", clientRepository.findAll(PageRequest.of(page, size)));
		
		
		
		Boolean estSupprimer=false;
		model.addAttribute("cheminAccueil",  "Accueil >");
		model.addAttribute("cheminSoumission",  "Soumission >");
		
		client.setNomAssure(nomAssure);
		client.setNomClient(nomClient);
		client.setNumero(numero);
		client.setPeriodicite(periodicite);
		client.setCouverture(couverture);
		client.setGenreAssure(genreAssure);
		client.setPrime(prime);
		client.setDatePrelevement(datePrelevement);
		client.setDateSoumission(dateSoumission);
		client.setDateNaissance(dateNaissance);
		client.setMatriculeClient(matriculeClient);
		client.setProfession(profession);
		client.setEmployeur(employeur);
		client.setVille(ville);
		client.setAdressePostale(adressePostal);
		client.setTellephone1(telephone1);
		client.setTellephone2(telephone2);
		client.setNomComPreContrat(nomComPreContrat);
		client.setEstSupprimer(estSupprimer);
		
		Agent agent=agentRepository.findAgentByCodeAgent(codeAgent);
		client.setIdAgent(agent);
		
		Plan plan=planRepository.findPlanByPlanDuree(planDuree); 
		String nomGuichetSoumis=session.getAttribute("nomGuichetSoumis").toString().trim();
		Banque banqueSoumise=banqueRepository.findBanqueByNomGuichet(nomGuichetSoumis);
		
		Client clientReturn=clientRepository.save(client);
		
		clientPlan.setIdClient(clientReturn);
		clientPlan.setIdPlan(plan);
		clientPlanRepository.save(clientPlan);
	
		clientBanque.setIdBanque(banqueSoumise);
		clientBanque.setIdClient(clientReturn);
		clientBanqueRepository.save(clientBanque);
		
		
		
		
		List<Client> soumissions=clientRepository.findAllClients(estSupprimer);
		model.addAttribute("soumissions", soumissions);
		
		
		model.addAttribute("listeSoumission", "listeSoumission");
		model.addAttribute("resultatAjoutProposition", "resultatAjoutProposition");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("titre", " Soumission de Proposition");
		model.addAttribute("identifiantSession", identifiantSession);
		model.addAttribute("menuNavigation", "menuNavigation");
        return "utilisateur/accueilUtilisateur";
    }	
	
}
