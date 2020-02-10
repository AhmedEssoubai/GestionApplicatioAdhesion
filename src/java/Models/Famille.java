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
    private ArrayList<Enfant> ListEnfants;
    private ArrayList<Tuteur> ListTuteurs;

    public Famille(ArrayList<Enfant> ListEnfants, ArrayList<Tuteur> ListTuteurs) {
        this.ListEnfants = ListEnfants;
        this.ListTuteurs = ListTuteurs;
    }

    public Famille(int ID_famille, ArrayList<Enfant> ListEnfants, ArrayList<Tuteur> ListTuteurs) {
        this.ID_famille = ID_famille;
        this.ListEnfants = ListEnfants;
        this.ListTuteurs = ListTuteurs;
    }

    public Famille() {
    }

    public int getID_famille() {
        return ID_famille;
    }

    public ArrayList<Enfant> getListEnfants() {
        return ListEnfants;
    }

    public ArrayList<Tuteur> getListTuteurs() {
        return ListTuteurs;
    }

    public void setID_famille(int ID_famille) {
        this.ID_famille = ID_famille;
    }

    public void setListEnfants(ArrayList<Enfant> ListEnfants) {
        this.ListEnfants = ListEnfants;
    }

    public void setListTuteurs(ArrayList<Tuteur> ListTuteurs) {
        this.ListTuteurs = ListTuteurs;
    }

    public Enfant rechercher_enf(int id){
        return this.ListEnfants.get(id);
    }
    public void delete_enf(Enfant E){
        E.setID_famille(0);
        this.ListEnfants.remove(E);
    }
    
       public Tuteur rechercher_Tuteur(int id){
        return this.ListTuteurs.get(id);
    }
    public void delete_Tut(Tuteur T){
        T.setID_famille(0);
        this.ListTuteurs.remove(T);
    }
}
