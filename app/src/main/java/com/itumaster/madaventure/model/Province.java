package com.itumaster.madaventure.model;

public class Province extends BaseModel{
    private String _id;
    private String nom;
    private String imagecouverture;
    private String couleur;
    private String description;
    private int nombreLieu;

    public Province() {
    }

    public Province(String _id, String nom, String imagecouverture, String couleur, String description, int nombreLieu) {
        this._id = _id;
        this.nom = nom;
        this.imagecouverture = imagecouverture;
        this.couleur = couleur;
        this.description = description;
        this.nombreLieu = nombreLieu;
    }



    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImageCouverture() {
        return imagecouverture;
    }

    public void setImageCouverture(String imageCouverture) {
        this.imagecouverture = imageCouverture;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombreLieu() {
        return nombreLieu;
    }

    public void setNombreLieu(int nombreLieu) {
        this.nombreLieu = nombreLieu;
    }
}
