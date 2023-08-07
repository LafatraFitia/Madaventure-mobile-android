package com.itumaster.madaventure.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Utilisateur extends BaseModel {
    private String _id;
    private String nom;
    private String prenom;
    private Date datenaissance;
    private String username;
    private String email;
    private String password;
    private String profilepicture;
    private Date datecreation;
    private String typeCompte;
    private int __v;



    public Utilisateur() {
        // Constructeur vide
    }

    public Utilisateur(String nom, String prenom, Date datenaissance, String username,
                       String email, String password, String profilepicture, Date datecreation,
                       String typeCompte) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilepicture = profilepicture;
        this.datecreation = datecreation;
        this.typeCompte = typeCompte;
    }

    public Utilisateur(String id, String nom, String prenom, Date datenaissance, String username, String email, String password, String profilepicture, Date datecreation, String typeCompte) {
        this._id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilepicture = profilepicture;
        this.datecreation = datecreation;
        this.typeCompte = typeCompte;
    }

    public Utilisateur(String email, String password) {
        setEmail(email);
        setPassword(password);
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    // Getters et setters pour tous les attributs

}


