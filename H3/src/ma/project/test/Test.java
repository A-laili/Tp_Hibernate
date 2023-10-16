/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.test;

import java.util.Date;
import ma.project.classes.Employe;
import ma.project.classes.Projet;
import ma.project.classes.Tache;
import ma.project.service.EmployeService;
import ma.project.service.ProjetService;
import ma.project.service.TacheService;

/**
 *
 * @author Asmaa
 */
public class Test {
     public static void main(String[] args){
    
        TacheService tacheService = new TacheService();
        ProjetService projetService = new ProjetService();
        EmployeService employeService = new EmployeService();
        
        Employe employe00 = new Employe("nom", "prenom", "0670520000");
        Projet projet00 = new Projet("Projet n00", new Date(), new Date(),employe00);
        Tache tache00 = new Tache("Tache n00",new Date(), new Date(), 23.0);
        
        
        Employe employe01 = new Employe("nom", "prenom", "0670520000");
        Projet projet01 = new Projet("Projet n00", new Date(), new Date(),employe00);
        Tache tache01 = new Tache("Tache n00",new Date(), new Date(), 23.0);
        
        employeService.create(employe00);
        employeService.create(employe01);
        
        
        projet00.getTache().add(tache00);
        projet00.getTache().add(tache01);
        
        projetService.create(projet00);
        
        
    
    }
    
}
