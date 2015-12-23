package dao;

import io.spring.guides.gs_producing_web_service.Pays;
import java.util.List;
import java.util.Map;

/**
 * Interface qui défini les methodes d'access a la base de donnée
 * 
 */
public interface IPaysDao {
    public boolean paysExiste(String nom);
    public boolean paysExiste(int id);
    public List findAllPays();
    public Pays findPays(String nom);
    public Pays findPays(int id);
    public List findAllPaysDanger(boolean danger);
    public List findListPays(Map<String,String> arg);
    public boolean ListPaysExist(Map<String,String> arg);
}

