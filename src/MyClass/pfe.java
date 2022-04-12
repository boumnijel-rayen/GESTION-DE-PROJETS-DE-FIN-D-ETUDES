/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClass;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class pfe {
    
    private int num_PFE;
    private String sujet;
    private String entraprise_A;
    private double note;
    private String etat;
    private String rapport_s;
    private int id_EN;
    private int id_R;
    private ArrayList<Integer> etudiants ;

    public pfe(int num_PFE, String sujet, String entraprise_A, double note, String etat, String rapport_s, int id_EN, int id_R) {
        this.num_PFE = num_PFE;
        this.sujet = sujet;
        this.entraprise_A = entraprise_A;
        this.note = note;
        this.etat = etat;
        this.rapport_s = rapport_s;
        this.id_EN = id_EN;
        this.id_R = id_R;
        this.etudiants = new ArrayList<Integer>();
    }

    public pfe(int num_PFE, String sujet, String entraprise_A, String etat, int id_EN, int id_R) {
        this.num_PFE = num_PFE;
        this.sujet = sujet;
        this.entraprise_A = entraprise_A;
        this.etat = etat;
        this.id_EN = id_EN;
        this.id_R = id_R;
        this.etudiants = new ArrayList<Integer>();
    }

    public pfe() {
        this.sujet = "";
        this.entraprise_A = "";
        this.etat = "";
        this.rapport_s = "";
        this.etudiants = new ArrayList<Integer>();
    }

    
    
    public int getNum_PFE() {
        return num_PFE;
    }

    public void setNum_PFE(int num_PFE) {
        this.num_PFE = num_PFE;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getEntraprise_A() {
        return entraprise_A;
    }

    public void setEntraprise_A(String entraprise_A) {
        this.entraprise_A = entraprise_A;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getRapport_s() {
        return rapport_s;
    }

    public void setRapport_s(String rapport_s) {
        this.rapport_s = rapport_s;
    }

    public int getId_EN() {
        return id_EN;
    }

    public void setId_EN(int id_EN) {
        this.id_EN = id_EN;
    }

    public int getId_R() {
        return id_R;
    }

    public void setId_R(int id_R) {
        this.id_R = id_R;
    }
    
    
    
}
