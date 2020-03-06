package Models;

import java.util.ArrayList;

/**
 *
 * @author Zed
 */
public class Famille {
    private int NUM_adhesion;
    private int ID_UTILISATEUR,ID_TUTEUR;
    private ArrayList<Enfant> ListEnfants;
    private ArrayList<Parent> ListTuteurs;
    private boolean RECEVOIR_OPT, DELEGUE_OPT;
    private int nbEnfants;
    private Parent tuteur;
    
    public Famille(ArrayList<Enfant> ListEnfants, ArrayList<Parent> ListTuteurs) {
        
        this.ListEnfants = ListEnfants;
        this.ListTuteurs = ListTuteurs;
    }

    public int getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(int nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public Parent getTuteur() {
        return tuteur;
    }

    public void setTuteur(Parent tuteur) {
        this.tuteur = tuteur;
    }

    public Famille(int NUM_adhesion, int ID_UTILISATEUR,int ID_TUTEUR, boolean RECEVOIR_OPT, boolean DELEGUE_OPT, ArrayList<Enfant> ListEnfants, ArrayList<Parent> ListTuteurs) {
        this.NUM_adhesion=NUM_adhesion;
        this.ID_UTILISATEUR=ID_UTILISATEUR;
        this.ID_TUTEUR=ID_TUTEUR;
        this.RECEVOIR_OPT = RECEVOIR_OPT;
        this.DELEGUE_OPT = DELEGUE_OPT;
        this.ListEnfants = ListEnfants;
        this.ListTuteurs = ListTuteurs;
    }
    public Famille(int ID_UTILISATEUR,int ID_TUTEUR, boolean RECEVOIR_OPT, boolean DELEGUE_OPT) {
        this.ID_UTILISATEUR=ID_UTILISATEUR;
        this.ID_TUTEUR=ID_TUTEUR;
        this.RECEVOIR_OPT = RECEVOIR_OPT;
        this.DELEGUE_OPT = DELEGUE_OPT;
    }
    
    public Famille(int num) {
        this.NUM_adhesion = num;
    }

    public int getNUM_adhesion() {
        return NUM_adhesion;
    }

    public ArrayList<Enfant> getListEnfants() {
        return ListEnfants;
    }

    public ArrayList<Parent> getListTuteurs() {
        return ListTuteurs;
    }
    public int getID_UTILISATEUR() {
        return ID_UTILISATEUR;
    }

    public int getID_TUTEUR() {
        return ID_TUTEUR;
    }

    public boolean getRECEVOIR_OPT() {
        return RECEVOIR_OPT;
    }

    public boolean getDELEGUE_OPT() {
        return DELEGUE_OPT;
    }
    
    public void setID_UTILISATEUR(int ID_UTILISATEUR) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }

    public void setID_TUTEUR(int ID_TUTEUR) {
        this.ID_TUTEUR = ID_TUTEUR;
    }
    
    public void setNUM_adhesion(int NUM_adhesion) {
        this.NUM_adhesion = NUM_adhesion;
    }

    public void setListEnfants(ArrayList<Enfant> ListEnfants) {
        this.ListEnfants = ListEnfants;
    }

    public void setListTuteurs(ArrayList<Parent> ListTuteurs) {
        this.ListTuteurs = ListTuteurs;
    }

    public void setRECEVOIR_OPT(boolean RECEVOIR_OPT) {
        this.RECEVOIR_OPT = RECEVOIR_OPT;
    }

    public void setDELEGUE_OPT(boolean DELEGUE_OPT) {
        this.DELEGUE_OPT = DELEGUE_OPT;
    }
    
    public Enfant rechercher_enf(int id){
        return this.ListEnfants.get(id);
    }
    public void delete_enf(Enfant E){
        E.setID_famille(0);
        this.ListEnfants.remove(E);
    }
    
       public Parent rechercher_Tuteur(int id){
        return this.ListTuteurs.get(id);
    }
    public void delete_Tut(Parent T){
        T.setID_famille(0);
        this.ListTuteurs.remove(T);
    }
    public void ajouter_Tut(Parent T){
        this.ListTuteurs.add(T);
        T.setID_famille(NUM_adhesion);
    }
}
