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
    private int num_PFE;
    
    
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Connection con;

    public etudiant(int id, String nom, String prenom, String email, String num_CIN, String password, int id_A,int num_PFE) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_CIN = num_CIN;
        this.password = password;
        this.id_A = id_A;
        this.num_PFE = num_PFE;
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
    
    public void ajouterRapport(String path){
        int num;
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select num_PFE from etudiant where id_E="+id);
            
            rs.next();
            num = rs.getInt("num_PFE");
            pfe p = new pfe();
            p.setNum_PFE(num);
            p.setRapport_s(path);
            p.ajoutRapport();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Boolean isEtatEncadre(){
        int num = 0;
        String etat="";
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select num_PFE from etudiant where id_E="+id);
            
            rs.next();
            num = rs.getInt("num_PFE");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select etat from pfe where num_PFE="+num);
            
            rs.next();
            etat = rs.getString("etat");
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if(etat.equals("encadre")){
                return true;
            }else{
                return false;
            }
    }
    
    public void affecterPFE(){
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            st.executeUpdate("update etudiant set num_PFE="+num_PFE+" where id_E="+id);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Boolean isHavePfe(){
        int num = 0;
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select num_PFE from etudiant where id_E="+id);
            
            rs.next();
            num = rs.getInt("num_PFE");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (num==0){
            return false;
        }else{
            return true;
        }
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

    public int getNum_PFE() {
        return num_PFE;
    }

    public void setNum_PFE(int num_PFE) {
        this.num_PFE = num_PFE;
    }
    
    
    
    
    
}
