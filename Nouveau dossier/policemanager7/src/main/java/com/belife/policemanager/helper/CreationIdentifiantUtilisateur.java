package com.belife.policemanager.helper;

import java.util.Random;

public class CreationIdentifiantUtilisateur {
	private String debutPasse="belife";
	private String finPasse="ur";
	
	public 	String IdentifiantUser() {		
		int nombre=genererNombre();
		String identifiant=debutPasse.concat(nombre+"").concat(finPasse);	
		return identifiant;
	}
	 
   @SuppressWarnings("unused")
private Integer genererNombre() {
	   int nombreSeuil=1000;
	   Random r=new Random();
	   int nombre=r.nextInt(1000);
	   int nombreGenere=nombreSeuil+nombre;
	   return nombreGenere;
   }
	

}
