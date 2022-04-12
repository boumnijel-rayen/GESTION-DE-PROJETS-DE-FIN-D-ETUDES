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
public class etudiant {
    
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String num_CIN;
    private String password;
    private int id_A;

    public etudiant(int id, String nom, String prenom, String email, String num_CIN, String password, int id_A) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_CIN = num_CIN;
        this.password = password;
        this.id_A = id_A;
    }

    public etudiant(int id, String nom, String prenom, String email, String num_CIN, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_CIN = num_CIN;
        this.password = password;
    }

    public etudiant() {
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.num_CIN = "";
        this.password = "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum_CIN() {
        return num_CIN;
    }

    public void setNum_CIN(String num_CIN) {
        this.num_CIN = num_CIN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_A() {
        return id_A;
    }

    public void setId_A(int id_A) {
        this.id_A = id_A;
    }
    
    
    
    
    
}
