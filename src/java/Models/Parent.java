package Models;

/**
 *
 * @author Zed
 */
public class Parent {
    private int ID;
    private String prenom;
    private String nom;
    private String cin;
    private String tel;
    private String email;
    private String profession;
    private int ID_famille;

    public Parent(String firstname, String lastname, String cin, String phone, String email, String job, int ID_famille) {
        this.prenom = firstname;
        this.nom = lastname;
        this.cin = cin;
        this.tel = phone;
        this.email = email;
        this.profession = job;
        this.ID_famille = ID_famille;
    }
    
    public Parent(int ID, String prenom, String nom, String cin, String Tel, String email, String profession,int ID_famille) {
        this.ID = ID;
        this.prenom = prenom;
        this.nom = nom;
        this.cin = cin;
        this.tel = Tel;
        this.email = email;
        this.profession = profession;
        this.ID_famille=ID_famille;
    }
    
    public Parent(int ID) {
        this.ID = ID;
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
        return tel;
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
        this.tel = Tel;
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
