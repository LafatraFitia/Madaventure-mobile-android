package com.itumaster.madaventure.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Utilisateur {
    private String _id;
    private String nom;
    private String prenom;
    private String datenaissance;
    private String username;
    private String email;
    private String password;
    private String profilepicture;
    private String datecreation;
    private String typeCompte;
    private int __v;

    public Utilisateur() {
        // Constructeur vide
    }

    public Utilisateur(String nom, String prenom, String datenaissance, String username,
                       String email, String password, String profilepicture, String datecreation,
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

    public Utilisateur(String id, String nom, String prenom, String datenaissance, String username, String email, String password, String profilepicture, String datecreation, String typeCompte) {
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

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
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

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
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

    public static Utilisateur fromJson(String json) {
        Utilisateur utilisateur = new Utilisateur();
        try {
            JSONObject jsonObject = new JSONObject(json);
            utilisateur.set_id(jsonObject.getString("_id"));
            utilisateur.setNom(jsonObject.getString("nom"));
            utilisateur.setPrenom(jsonObject.getString("prenom"));
            utilisateur.setDatenaissance(jsonObject.getString("datenaissance"));
            utilisateur.setUsername(jsonObject.getString("username"));
            utilisateur.setEmail(jsonObject.getString("email"));
            utilisateur.setPassword(jsonObject.getString("password"));
            utilisateur.setProfilepicture(jsonObject.getString("profilepicture"));
            utilisateur.setDatecreation(jsonObject.getString("datecreation"));
            utilisateur.setTypeCompte(jsonObject.getString("typeCompte"));
            utilisateur.set__v(jsonObject.getInt("__v"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }
}


