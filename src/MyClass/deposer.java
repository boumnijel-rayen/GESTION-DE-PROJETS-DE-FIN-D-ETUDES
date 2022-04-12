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
public class deposer {
    
    private int id_E;
    private int num_PFE;

    public deposer(int id_E, int num_PFE) {
        this.id_E = id_E;
        this.num_PFE = num_PFE;
    }

    public deposer() {
        this.id_E = 0;
        this.num_PFE = 0;
    }

    public int getId_E() {
        return id_E;
    }

    public void setId_E(int id_E) {
        this.id_E = id_E;
    }

    public int getNum_PFE() {
        return num_PFE;
    }

    public void setNum_PFE(int num_PFE) {
        this.num_PFE = num_PFE;
    }
    
    
    
    
    
}
