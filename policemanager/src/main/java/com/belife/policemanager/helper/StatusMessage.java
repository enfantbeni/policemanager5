/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belife.policemanager.helper;

/**
 *
 * @author fossouulrich
 */
public class StatusMessage {
    
    public static final String SUCCESS="Opération effectuée avec succès";

    public static final String TECH_DB_NOT_CONNECT="Impossible de se connecter à la base de données";
    public static final String TECH_DB_FAIL="La base de données est indisponible";
    public static final String TECH_INTERN_ERROR="Erreur interne";
    public static final String TECH_DB_PERMISSION_DENIED="Permission refusée par la base de données";
    public static final String TECH_DB_QUERY_REFUSED="Le serveur de base de données a refusé la requete";

    
    public static final String FUNC_AUTH_FAIL="Authentification echouée";
    public static final String FUNC_DATA_NOT_EXIST="Donnée inexistante";
    public static final String FUNC_DATA_EMPTY="Liste vide";
    public static final String FUNC_DATA_EXIST="Donnée déja existante";
    public static final String FUNC_FIELD_EMPTY="Champ non renseigné";
    public static final String FUNC_USER_ALREADY_CONNECTED="Utilisateur déja connecté";
    public static final String FUNC_REQUEST_FAIL="la requete attendue n'est celle fournie";
    public static final String FUNC_TYPE_NOT_CORRECT="Le type est incorrect";
    public static final String FUNC_DATE_FORMAT_NOT_CORRECT="Le format de la date est incorrect";
    public static final String FUNC_INVALID_FORMAT="le serveur a signalé un format invalide";
    
}
