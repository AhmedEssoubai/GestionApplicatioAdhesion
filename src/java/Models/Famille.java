/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Zed
 */
public class Famille {
    private int ID_famille;
    private int ID_UTILISATEUR,ID_TUTEUR,RECEVOIR_OPT;
    private ArrayList<Enfant> ListEnfants;
    private ArrayList<Parents> ListTuteurs;
    
    public Famille(ArrayList<Enfant> ListEnfants, ArrayList<Parents> ListTuteurs) {
        
        this.ListEnfants = ListEnfants;
        this.ListTuteurs = ListTuteurs;
    }

    

    public Famille(int ID_famille,int ID_UTILISATEUR,int ID_TUTEUR ,int RECEVOIR_OPT ,ArrayList<Enfant> ListEnfants, ArrayList<Parents> ListTuteurs) {
        this.ID_famille=ID_famille;
        this.ID_UTILISATEUR=ID_UTILISATEUR;
        this.ID_TUTEUR=ID_TUTEUR;
        this.RECEVOIR_OPT=RECEVOIR_OPT;
        this.ListEnfants = ListEnfants;
        this.ListTuteurs = ListTuteurs;
    }
    public Famille(int ID_UTILISATEUR,int ID_TUTEUR ,int RECEVOIR_OPT) {
        this.ID_UTILISATEUR=ID_UTILISATEUR;
        this.ID_TUTEUR=ID_TUTEUR;
        this.RECEVOIR_OPT=RECEVOIR_OPT;
       
    }
    public Famille() {
    }

    public int getID_famille() {
        return ID_famille;
    }

    public ArrayList<Enfant> getListEnfants() {
        return ListEnfants;
    }

    public ArrayList<Parents> getListTuteurs() {
        return ListTuteurs;
    }
    public int getID_UTILISATEUR() {
        return ID_UTILISATEUR;
    }

    public int getID_TUTEUR() {
        return ID_TUTEUR;
    }

    public int getRECEVOIR_OPT() {
        return RECEVOIR_OPT;
    }
    
    public void setID_UTILISATEUR(int ID_UTILISATEUR) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }

    public void setID_TUTEUR(int ID_TUTEUR) {
        this.ID_TUTEUR = ID_TUTEUR;
    }
    
    public void setID_famille(int ID_famille) {
        this.ID_famille = ID_famille;
    }

    public void setListEnfants(ArrayList<Enfant> ListEnfants) {
        this.ListEnfants = ListEnfants;
    }

    public void setListTuteurs(ArrayList<Parents> ListTuteurs) {
        this.ListTuteurs = ListTuteurs;
    }

    public void setRECEVOIR_OPT(int RECEVOIR_OPT) {
        this.RECEVOIR_OPT = RECEVOIR_OPT;
    }
    
    public Enfant rechercher_enf(int id){
        return this.ListEnfants.get(id);
    }
    public void delete_enf(Enfant E){
        E.setID_famille(0);
        this.ListEnfants.remove(E);
    }
    
       public Parents rechercher_Tuteur(int id){
        return this.ListTuteurs.get(id);
    }
    public void delete_Tut(Parents T){
        T.setID_famille(0);
        this.ListTuteurs.remove(T);
    }
    public void ajouter_Tut(Parents T){
        this.ListTuteurs.add(T);
        T.setID_famille(ID_famille);
    }
}
