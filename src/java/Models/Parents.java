/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Zed
 */
public class Parents {
    private int ID;
    private String prenom;
    private String nom;
    private String cin;
    private String Tel;
    private String email;
    private String profession;
    private int ID_famille;

    public Parents(String firstname, String lastname, String cin, String phone, String email, String job) {
        this.prenom = firstname;
        this.nom = lastname;
        this.cin = cin;
        this.Tel = phone;
        this.email = email;
        this.profession = job;
        
    }

    

    public Parents(int ID, String prenom, String nom, String cin, String Tel, String email, String profession) {
        this.ID = ID;
        this.prenom = prenom;
        this.nom = nom;
        this.cin = cin;
        this.Tel = Tel;
        this.email = email;
        this.profession = profession;
    }

    public int getID() {
        return ID;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getCin() {
        return cin;
    }

    public String getTel() {
        return Tel;
    }

    public String getEmail() {
        return email;
    }

    public String getProfession() {
        return profession;
    }

    public int getID_famille() {
        return ID_famille;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setID_famille(int ID_famille) {
        this.ID_famille = ID_famille;
    }
    
  
    
    
    
    
    
    
}
