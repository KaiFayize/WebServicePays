/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsconfig;

import exceptions.PaysNotFoundException;
import java.util.ArrayList;
import java.util.List;

import io.spring.guides.gs_producing_web_service.Pays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.IPaysMetier;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
/**
 * PaysRepository est la classe qui fais le lien avec la base de donnée
 * 
 */
@Component
public class PaysRepository {

    /**
     * Renvoye un pays trouvé dans la base de donnée
     * @param name Le nom du pays que l'on veut trouver
     * @return Le pays correspondant
     */
    public Pays findPays(String name){
   
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        Pays result= new Pays();
        String libelle = name;
        try{
            result = instance.findPays(libelle);
            System.out.println("libelle get : " +result.getLibelleFr());            
        }
        catch (PaysNotFoundException e){
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Renvoye un pays trouvé dans la base de donnée
     * @param id L'ID du pays que l'on veut trouver
     * @return Le pays correspondant
     */
    public Pays findPays(int id){
   
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        Pays result= new Pays();
        try{
            result = instance.findPays(id);
            System.out.println("libelle get : " +result.getLibelleFr() + " ID: " + result.getID());            
        }
        catch (PaysNotFoundException e){
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    /**
     * Renvoye la liste de nom de tout les pays présent dans la base de donnée.
     * @return La liste des nom de tout les pays.
     */
    public List findAllPaysName(){

        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        List<Pays> result = instance.findAllPays();
        List<String> resultlist = new ArrayList<>();
        for (Pays pays : result) {
            System.out.println("libelle : " + pays.getLibelleFr());
            resultlist.add(pays.getLibelleFr());
        } 
        return resultlist;
    }
    
    /**
     * Renvoye la liste de tout les pays présent dans la base de donnée
     * @return La liste de tout les pays
     */
    public List findAllPays(){

        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        List<Pays> result = instance.findAllPays();
        for (Pays pays : result) {
            System.out.println("libelle : " + pays.getLibelleFr());
        } 
        return result;
    }
    
    /**
     * Renvoye la liste des pays en fonction de leurs dangerosité
     * @param danger True pour les pays dangereux, false sinon
     * @return La liste de pays correspondant
     */
    public List findAllPaysDanger(boolean danger){

        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        List<Pays> result = instance.findAllPaysDanger(danger);
        for (Pays pays : result) {
            System.out.println("libelle : " + pays.getLibelleFr());
        } 
        return result;
    }
    
    /**
     * Renvoie une liste de pays en fonction de differement paramettre 
     * @param arg Map qui peut contenir des valeurs avec les clés suivante pour construir une requete:
     * libelle: pour les libelles qu'on cherches
     * indicatif: pour les indicatif qu'on cherches
     * monnaie_code: pour les monnaie code qu'on cherche
     * monnaie_perdiem: pour les monnaie perdiem
     * monnaie_perdiem_arg: doit contenir "+" si on cherche les monnaie perdiem superieur, ou "-" si inferieur
     * taux_change: pour les taux change
     * taux_change_arg: doit contenir "+" si on cherche les taux change superieur, ou "-" si inferieur
     * @return La liste des pays correspondant qui réponds aux arguments données
     */
    public List findListPays(HashMap<String,String> arg){

        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        List<Pays> result =null;
        try {
            result = instance.findListPays(arg);        
            for (Pays pays : result) {
            System.out.println("libelle : " + pays.getLibelleFr());
        } 
        } catch (PaysNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }
}
