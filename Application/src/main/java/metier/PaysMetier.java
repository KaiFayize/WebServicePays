package metier;

import entite.User;
import dao.IPaysDao;
import entite.Pays;
import exceptions.PaysNotFoundException;
import exceptions.UserNotFoundException;
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
    @Override
    public List findAllPays(){
        return paysDao.findAllPays();
    }
    
    
    /**
     * Renvoie un pays
     * @param nom le nom du pays cherché
     * @return Le pays trouvé
     * @throws PaysNotFoundException Si le pays n'existe pas
     */
    @Override
    public Pays findPays(String nom) throws PaysNotFoundException{

        if (!paysDao.paysExiste(nom)) {
          throw new PaysNotFoundException();
        }
        return paysDao.findPays(nom);
    }
    
    
    @Override
    public User findUser(String login) throws UserNotFoundException{

        if (!paysDao.userExiste(login)) {
          throw new UserNotFoundException();
        }
        return paysDao.findUser(login);
    }
    /**
     * Renvoie la liste des pays en fonction de leurs dangerosité
     * @param danger True pour les pays dangereux, false sinon
     * @return La liste de pays correspondant
     */
    @Override
    public List findAllPaysDanger(boolean danger){
        return paysDao.findAllPaysDanger(danger);
    }

    @Override
    public List findListPays(Map<String,String> arg) throws PaysNotFoundException {
        
        if (!paysDao.ListPaysExist(arg)) {
          throw new PaysNotFoundException();
        }
        return paysDao.findListPays(arg);
    }

    @Override
    public void createPays(Map<String, String> arg) {
        paysDao.createPays(arg);
    }

    @Override
    public void deletePays(String nom) {
        paysDao.deletePays(nom);
    }

    @Override
    public void updatePays(String nom, Map<String, String> arg) {
        paysDao.updatePays(nom, arg);
    }

    
}


