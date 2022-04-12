/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClass;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class rapporteur extends enseignant{
    
    private ArrayList<Integer> PFEs ;

    public rapporteur(int id, String nom, String prenom, String email, int id_A, String password, String cin) {
        super(id, nom, prenom, email, id_A, password, cin);
        this.PFEs = new ArrayList<Integer>();
    }

    public rapporteur(int id, String nom, String prenom, String email, String password, String cin) {
        super(id, nom, prenom, email, password, cin);
        this.PFEs = new ArrayList<Integer>();
    }

    public rapporteur() {
        super();
        this.PFEs = new ArrayList<Integer>();
    }
    
    
}
