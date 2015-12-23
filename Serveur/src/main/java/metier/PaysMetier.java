package metier;

import dao.IPaysDao;
import io.spring.guides.gs_producing_web_service.Pays;
import exceptions.PaysNotFoundException;
import java.util.List;
import java.util.Map;



/**
 * PaysMetier est la classe qui utilise les PaysDao pour obtenir des Objet Pays
 * 
 */
public class PaysMetier implements IPaysMetier {
    /**
     * PaysDao de cette instance de PaysMetier
     */
    IPaysDao paysDao;
    
    /**
     * Fixe le PaysDao de cette instance
     * @param paysDao Un PaysDao donné
     */
    public void setPaysDao(IPaysDao paysDao){
        this.paysDao=paysDao;
    }
    

    public PaysMetier(){

    }
    
    /**
     * Renvoie la liste dee tout les Pays
     * @return 
     */
    public List findAllPays(){
        return paysDao.findAllPays();
    }
    
    
    /**
     * Renvoie un pays
     * @param nom le nom du pays cherché
     * @return Le pays trouvé
     * @throws PaysNotFoundException Si le pays n'existe pas
     */
    public Pays findPays(String nom) throws PaysNotFoundException{

        if (!paysDao.paysExiste(nom)) {
          throw new PaysNotFoundException();
        }
        return paysDao.findPays(nom);
    }
    
    /**
     * Renvoie un pays
     * @param id l'ID du pays cherché
     * @return Le pays trouvé
     * @throws PaysNotFoundException Si le pays n'existe pas
     */
    public Pays findPays(int id) throws PaysNotFoundException{

        if (!paysDao.paysExiste(id)) {
          throw new PaysNotFoundException();
        }
        return paysDao.findPays(id);
    }
    
    /**
     * Renvoie la liste des pays en fonction de leurs dangerosité
     * @param danger True pour les pays dangereux, false sinon
     * @return La liste de pays correspondant
     */
    public List findAllPaysDanger(boolean danger){
        return paysDao.findAllPaysDanger(danger);
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
     * @throws exceptions.PaysNotFoundException Si aucun pays ne corresponds à la requète
     */
    public List findListPays(Map<String,String> arg) throws PaysNotFoundException {
        
        if (!paysDao.ListPaysExist(arg)) {
          throw new PaysNotFoundException();
        }
        return paysDao.findListPays(arg);
    }
}


