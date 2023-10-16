/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.test;

import java.util.Date;
import ma.project.classes.Commande;
import ma.project.services.CammandeService;

/**
 *
 * @author Asmaa
 */
public class TestCommande {
       public static void main(String[] args) {

        CammandeService cs = new CammandeService();
        cs.create(new Commande(new Date()) );
        
}
}
