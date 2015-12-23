package dao;

import entite.Pays;
import java.util.List;
import java.util.Map;
import entite.User;

/**
 * Interface qui défini les methodes d'access a la base de donnée
 * 
 */
public interface IPaysDao {
    public boolean paysExiste(String nom);
    public boolean userExiste(String login);
    public User findUser(String login);
    public List findAllPays();
    public Pays findPays(String nom);
    public List findAllPaysDanger(boolean danger);
    public List findListPays(Map<String,String> arg);
    public boolean ListPaysExist(Map<String,String> arg);
    
    public int updatePays(String libelle, Map<String,String> arg);
    public void deletePays(String nom);
    public void createPays(Map<String,String> arg);
}

