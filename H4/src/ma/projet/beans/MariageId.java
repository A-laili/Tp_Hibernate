/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class MariageId implements Serializable {
    
    private int homme_id;
    private int femme_id;

    public MariageId() {
    }

    public MariageId(int homme_id, int femme_id) {
        this.homme_id = homme_id;
        this.femme_id = femme_id;
    }

    public int getHomme_id() {
        return homme_id;
    }

    public void setHomme_id(int homme_id) {
        this.homme_id = homme_id;
    }

    public int getFemme_id() {
        return femme_id;
    }

    public void setFemme_id(int femme_id) {
        this.femme_id = femme_id;
    }
    
    
}
