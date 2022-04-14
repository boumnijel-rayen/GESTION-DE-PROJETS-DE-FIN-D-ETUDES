/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class encadrant{
    
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int id_A;
    private String password;
    private String cin;
    
    private ArrayList<Integer> PFEs ;
    
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Connection con;

    public encadrant(int id, String nom, String prenom, String email, int id_A, String password, String cin, ArrayList<Integer> PFEs) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.id_A = id_A;
        this.password = password;
        this.cin = cin;
        this.PFEs = PFEs;
    }

    public encadrant() {
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.password = "";
        this.cin = "";
        this.PFEs = new ArrayList<Integer>();
    }

    public String showInfosEncadrant(){
        String infos="";
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select nom,prenom,email from encadrant where id_EN="+id);
            
            rs.next();
            infos = "nom : "+rs.getString("nom")+"\nprenom : "+rs.getString("prenom")+"\nemail : "+rs.getString("email");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return infos;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public ArrayList<Integer> getPFEs() {
        return PFEs;
    }

    public void setPFEs(ArrayList<Integer> PFEs) {
        this.PFEs = PFEs;
    }

    
    
    
    
}
