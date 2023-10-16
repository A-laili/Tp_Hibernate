/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.classes;

import java.io.Serializable;

/**
 *
 * @author Asmaa
 */
public class EmployeTachePK implements Serializable{
    
    private int tache;
    
    private int employe;

    public EmployeTachePK() {
    }

    public EmployeTachePK(int employe, int tache) {
        this.employe = employe;
        this.tache = tache;
    }

    public int getProduit() {
        return employe;
    }

    public void setProduit(int employe) {
        this.employe = employe;
    }

    public int getCommande() {
        return tache;
    }

    public void setCommande(int tache) {
        this.tache = tache;
    }
}
