/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.test;

import ma.project.services.CammandeService;
import ma.project.services.LigneCommandeService;
import ma.project.services.ProduitServices;

/**
 *
 * @author Asmaa
 */
public class TestFindProduitByCommande {
    public static void main(String[] args) {
        CammandeService cs = new CammandeService();
        ProduitServices ps = new ProduitServices();
        LigneCommandeService lcps = new LigneCommandeService();
        
        ps.findProduitByCommande(cs.getById(1));
    }
}
