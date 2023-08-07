package com.itumaster.madaventure.model;

import java.util.Date;
import java.util.List;

public class Lieu extends BaseModel {
    private String _id;
    private String nom;
    private String description;
    private String corpstextuel;
    private String imagecouverture;
    private String idutilisateur;
    private String province;
    private List<String> activites;
    private Date datecreation;
    private List<String> images;
    private boolean isDeleted;
    private int __v;
    private Date dateSuppression;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCorpstextuel() {
        return corpstextuel;
    }

    public void setCorpstextuel(String corpstextuel) {
        this.corpstextuel = corpstextuel;
    }

    public String getImageCouverture() {
        return imagecouverture;
    }

    public void setImageCouverture(String imageCouverture) {
        this.imagecouverture = imageCouverture;
    }

    public String getIdUtilisateur() {
        return idutilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idutilisateur = idUtilisateur;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getActivites() {
        return activites;
    }

    public void setActivites(List<String> activites) {
        this.activites = activites;
    }

    public void addActivitie(String activite) {
        if (this.activites.indexOf(activite) == -1) {
            this.activites.add(activite);
        }
    }

    public void removeActivitie(String activite) {
        int indice = this.activites.indexOf(activite);
        if ( indice != -1) {
            this.activites.remove(indice);
        }
    }

    public Date getDateCreation() {
        return datecreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.datecreation = dateCreation;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void addImage(String image) {
        if (this.images.indexOf(image) == -1) {
            this.images.add(image);
        }
    }

    public void removeImage(String image) {
        int indice = this.images.indexOf(image);
        if ( indice != -1) {
            this.images.remove(indice);
        }
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    // Ajoutez ici les autres méthodes nécessaires, telles que les constructeurs, toString, etc.
}

