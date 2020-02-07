/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Zed
 */
public class Enfant {
    private String firstname;
    private String lastname;
    private String cin;
    private String cne;
    private int phone;
    private String email;
    private Date dateofbirth;
    private String grade;
    private ArrayList<String> Tuteurs;
    public Enfant() {
    }

    public Enfant(String firstname, String lastname, String cin, String cne, int phone, String email, Date dateofbirth, String grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cin = cin;
        this.cne = cne;
        this.phone = phone;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.grade = grade;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCin() {
        return cin;
    }

    public String getCne() {
        return cne;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public String getGrade() {
        return grade;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<String> getTuteurs() {
        return Tuteurs;
    }

    public void setTuteurs(ArrayList<String> Tuteurs) {
        this.Tuteurs = Tuteurs;
    }
    
    
    
}
