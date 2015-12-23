package metier;

import io.spring.guides.gs_producing_web_service.Pays;
import exceptions.PaysNotFoundException;
import java.util.List;
import java.util.Map;


/**
 * Interface qui défini les methodes gerant les Objet Pays
 * 
 */
public interface IPaysMetier {
    
    public List findAllPays();
    public Pays findPays(String nom) throws PaysNotFoundException;
    public Pays findPays(int id) throws PaysNotFoundException;
    public List findAllPaysDanger(boolean danger);
    public List findListPays(Map<String,String> arg) throws PaysNotFoundException;
}
