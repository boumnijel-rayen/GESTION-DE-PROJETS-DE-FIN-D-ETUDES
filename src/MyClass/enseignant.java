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
public class enseignant {
    
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int id_A;
    private String password;
    private String cin;
    

    public enseignant(int id, String nom, String prenom, String email, int id_A, String password, String cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.id_A = id_A;
        this.password = password;
        this.cin = cin;
    }

    public enseignant(int id, String nom, String prenom, String email, String password, String cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.cin = cin;
    }

    public enseignant() {
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.password = "";
        this.cin = "";
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_A() {
        return id_A;
    }

    public void setId_A(int id_A) {
        this.id_A = id_A;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    
    
    
}
