package metier;

import entite.User;
import entite.Pays;
import exceptions.PaysNotFoundException;
import exceptions.UserNotFoundException;
import java.util.List;
import java.util.Map;


/**
 * Interface qui défini les methodes gerant les Objet Pays
 * 
 */
public interface IPaysMetier {
    
    public List findAllPays();
    public Pays findPays(String nom) throws PaysNotFoundException;
    public User findUser(String login) throws UserNotFoundException;
    public List findAllPaysDanger(boolean danger);
    public List findListPays(Map<String,String> arg) throws PaysNotFoundException;
    public void createPays(Map<String,String> arg);
    public void deletePays(String nom);
    public void updatePays(String nom, Map<String,String> arg);
}
