/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Homme;
import ma.projet.service.HommeService;

/**
 *
 * @author hp
 */
public class Test {
    public static void main(String[] args){
    
        HommeService hommeService = new HommeService();
        hommeService.create(new Homme("nom","prenom","tele","adress",new Date()));
        hommeService.create(new Homme("nom","prenom","tele","adress", new Date(121, 8, 29)));
    
    }
    
}
