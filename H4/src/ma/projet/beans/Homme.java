/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 *
 * @author hp
 */
@Entity
public class Homme extends Personne {
    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    
    @OneToMany(mappedBy = "homme")
    private List<Mariage> mariages;

    public Homme() {
        mariages = new ArrayList<Mariage>();
    }

    public Homme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
        mariages = new ArrayList<Mariage>();    
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
   
    
}
