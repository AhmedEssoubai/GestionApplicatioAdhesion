package Models;

import java.util.Date;

/**
 *
 * @author Zed
 */
public class Enfant {
    private int ID;
    private String nom;
    private String prenom;
    private String cne; 
    private Date date_naissence;
    private String grade;
    private String assurance;
    private int ID_famille;

    public Enfant(int ID, String nom, String prenom, String cne,Date date_naissence, String grade,String Assurance, int ID_famille) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.date_naissence = date_naissence;
        this.grade = grade;
        this.assurance=Assurance;
        this.ID_famille = ID_famille;
    }

    public Enfant(String nom, String prenom, String cne, Date date_naissence, String grade,String Assurance, int ID_famille) {
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.date_naissence = date_naissence;
        this.grade = grade;
        this.assurance=Assurance;
        this.ID_famille = ID_famille;
    }

    public Enfant(int id) {
        ID = id;
    }

    public int getID_famille() {
        return ID_famille;
    }

    public void setID_famille(int ID_famille) {
        this.ID_famille = ID_famille;
    }

    
    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCne() {
        return cne;
    }

    public Date getDate_naissence() {
        return date_naissence;
    }

    public String getGrade() {
        return grade;
    }
    public String getAssurance() {
        return assurance;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

  

    public void setDate_naissence(Date date_naissence) {
        this.date_naissence = date_naissence;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
   

    public void setAssurance(String Assurance) {
        this.assurance = Assurance;
    }

    
    
    
}
