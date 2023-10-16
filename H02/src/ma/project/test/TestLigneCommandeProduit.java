/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.test;

import ma.project.classes.Commande;
import ma.project.classes.LigneCommandeProduit;
import ma.project.classes.LigneCommandeProduitPK;
import ma.project.classes.Produit;
import ma.project.services.CammandeService;
import ma.project.services.LigneCommandeService;
import ma.project.services.ProduitServices;

/**
 *
 * @author Asmaa
 */
public class TestLigneCommandeProduit {
      public static void main(String[] args) {
        CammandeService cs = new CammandeService();
        ProduitServices ps = new ProduitServices();
        LigneCommandeService lcps = new LigneCommandeService();
        Commande c = cs.getById(1);
        Produit p = ps.getById(1);
        Produit p2 = ps.getById(2);

        LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(p.getId(), c.getId());
        LigneCommandeProduitPK lpk2 = new LigneCommandeProduitPK(p2.getId(), c.getId());
        
        LigneCommandeProduit lp = new LigneCommandeProduit(lpk, 10);
        LigneCommandeProduit lp2 = new LigneCommandeProduit(lpk2, 10);
        lcps.create(lp);
        lcps.create(lp2);
       
    }

}
