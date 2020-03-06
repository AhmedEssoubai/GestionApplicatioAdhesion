package Models;

/**
 *
 * @author Zed
 */
public class Utilisateur {
    private int ID;
    private String email;
    private String password;

    public Utilisateur(int ID, String email, String password) {
        this.ID = ID;
        this.email = email;
        this.password = password;
    }

    public Utilisateur(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Utilisateur(int id) {
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
    
   
    
    
    
    
}
