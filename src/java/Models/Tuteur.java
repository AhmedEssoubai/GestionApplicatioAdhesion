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
public class Tuteur {
    private String prenom;
    private String nom;
    private String cin;
    private int Tel;
    private String email;
    private String profession;

    public Tuteur(String firstname, String lastname, String cin, int phone, String email, String job) {
        this.prenom = firstname;
        this.nom = lastname;
        this.cin = cin;
        this.Tel = phone;
        this.email = email;
        this.profession = job;
        
    }

    public Tuteur() {
    }
        
    
    public String getPrenom() {
        return prenom;
    }

    public String getLastname() {
        return nom;
    }

    public String getCin() {
        return cin;
    }

    public int getTel() {
        return Tel;
    }

    public String getEmail() {
        return email;
    }

    public String getProfession() {
        return profession;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLastname(String lastname) {
        this.nom = lastname;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    
    
    
    
    
}
