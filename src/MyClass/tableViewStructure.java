/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClass;

/**
 *
 * @author asus
 */
public class tableViewStructure {
    
    private int num;
    private String sujet;
    private String enreprise;
    private String nom;
    private String prenom;
    private String email;
    private String emailB;

    public tableViewStructure(int num, String sujet, String enreprise, String nom, String prenom, String email) {
        this.num = num;
        this.sujet = sujet;
        this.enreprise = enreprise;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public tableViewStructure(int num, String sujet, String enreprise, String nom, String prenom, String email, String emailB) {
        this.num = num;
        this.sujet = sujet;
        this.enreprise = enreprise;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.emailB = emailB;
    }

    public tableViewStructure() {
        this.num = 0;
        this.sujet = "";
        this.enreprise = "";
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.emailB = "";
    }

    public String getEmailB() {
        return emailB;
    }

    public void setEmailB(String emailB) {
        this.emailB = emailB;
    }
    
    

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getEnreprise() {
        return enreprise;
    }

    public void setEnreprise(String enreprise) {
        this.enreprise = enreprise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
