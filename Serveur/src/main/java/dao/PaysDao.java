package dao;

import io.spring.guides.gs_producing_web_service.Pays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * PaysDao est la classe qui possedent les methodes accedant directement a la base de donnée
 * 
 */
public class PaysDao  implements IPaysDao {
    
    /**
     * Le JdbcTemplate qui permettras de faire des opérations sur la base de donnée
     */
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Fixe la base de donnée sur laquel les opérations seront effectué
     * @param datasource 
     */
    public void setDatasource(DataSource datasource) {
      this.jdbcTemplate = new JdbcTemplate(datasource);
    }
  /**
   * Renvoie si un pays existe ou non
   * @param nom Le nom du pays cherché
   * @return Si le pays existe ou non
   */
    @Override
    public boolean paysExiste(String nom) {
        String sql="select count(*) from pays.pays where libelle_fr =?";
        int count=jdbcTemplate.queryForInt(sql,new Object[]{nom});
        return count > 0 ? true : false;
    }

      /**
   * Renvoie si un pays existe ou non
   * @param id L'ID du pays cherché
   * @return Si le pays existe ou non
   */
    @Override
    public boolean paysExiste(int id) {
        String sql="select count(*) from pays.pays where ID =?";
        int count=jdbcTemplate.queryForInt(sql,new Object[]{id});
        return count > 0 ? true : false;
    }
    
    /**
     * Renvoie la liste de tous les pays de la base de donnée
     * @return La liste de tout les pays
     */
    @Override
    public List findAllPays() {
        String sql="select * from pays.pays";   
        List<Pays> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Pays.class));
        return list;
    }

    
    /**
     * Renvoie un pays
     * @param nom le nom du pays cherché
     * @return Le pays trouvé
     */
    @Override
    public Pays findPays(String nom) {
        String sql = "select *from pays.pays WHERE libelle_fr = ?" ;
       
        Pays pays = (Pays)jdbcTemplate.queryForObject(
			sql, new Object[] { nom }, 
			new BeanPropertyRowMapper(Pays.class)); 
        
        return pays;
    }
    
    /**
     * Renvoie un pays
     * @param id l'ID du pays cherché
     * @return Le pays trouvé
     */
    @Override
    public Pays findPays(int id) {
        String sql = "select *from pays.pays WHERE ID = ?" ;
       
        Pays pays = (Pays)jdbcTemplate.queryForObject(
			sql, new Object[] { id }, 
			new BeanPropertyRowMapper(Pays.class)); 
        
        return pays;
    }
    /**
      * Renvoie la liste des pays en fonction de leurs dangerosité
      * @param danger True pour les pays dangereux, false sinon
      * @return La liste de pays correspondant
     */
    @Override
    public List findAllPaysDanger(boolean danger) {
        String sql = "select *from pays.pays WHERE danger = ?" ;       
        List<Pays> list = jdbcTemplate.query(sql,new Object[] { danger}, new BeanPropertyRowMapper(Pays.class));
        return list;
        
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
    @Override
    public List findListPays(Map<String,String> arg) {
        
        String sql = "select *from pays.pays where libelle_fr like ? " ;   
        StringBuilder bsql = new StringBuilder(sql);
        
        Object[] obj = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<Object>(Arrays.asList(obj));
                
        if(arg.containsKey("libelle")){
            newObj.add(arg.get("libelle")+"%");            
        }
        else newObj.add("%");
        
        if(arg.containsKey("indicatif")){
            newObj.add(arg.get("indicatif")+"%"); 
            bsql.append("and indicatif like ?");
        }
        
        if(arg.containsKey("monnaie_code")){
            newObj.add(arg.get("monnaie_code")+"%"); 
            bsql.append("and monnaie_code like ?");
        }
        
        if(arg.containsKey("danger")){
            if((arg.get("danger")=="true")||(arg.get("danger")=="1")){
                newObj.add("1");
            }
            else newObj.add("0");
   
            bsql.append("and danger = ?");
        }
        
        if(arg.containsKey("monnaie_perdiem")){
            newObj.add(arg.get("monnaie_perdiem"));
            if(arg.containsKey("monnaie_perdiem_arg")){
                 
                switch (arg.get("monnaie_perdiem_arg")){
                    case "+":
                        bsql.append("and monnaie_perdiem >= ?");
                        break;
                    case "-":
                        bsql.append("and monnaie_perdiem <= ?");
                        break;
                    default:
                        bsql.append("and monnaie_perdiem = ?");                         
                }
            }
            else bsql.append("and monnaie_perdiem = ?");                     
        }
        
        if(arg.containsKey("taux_change")){
            newObj.add(arg.get("taux_change"));
            if(arg.containsKey("taux_change_arg")){
                 
                switch (arg.get("taux_change_arg")){
                    case "+":
                        bsql.append("and taux_change >= ?");
                        break;
                    case "-":
                        bsql.append("and taux_change <= ?");
                        break;
                    default:
                        bsql.append("and taux_change = ?");                         
                }
            }
            else bsql.append("and taux_change = ?");                     
        }
 
        sql = bsql.toString();
               
        List<Pays> list = jdbcTemplate.query(sql,newObj.toArray(), new BeanPropertyRowMapper(Pays.class));
        return list; 
    }
    
    
    
    /**
     * Verifie si une liste de pays correspondant a des arguments existe
     @param arg Map qui peut contenir des valeurs avec les clés suivante pour construir une requete:
     * libelle: pour les libelles qu'on cherches
     * indicatif: pour les indicatif qu'on cherches
     * monnaie_code: pour les monnaie code qu'on cherche
     * monnaie_perdiem: pour les monnaie perdiem
     * monnaie_perdiem_arg: doit contenir "+" si on cherche les monnaie perdiem superieur, ou "-" si inferieur
     * taux_change: pour les taux change
     * taux_change_arg: doit contenir "+" si on cherche les taux change superieur, ou "-" si inferieur
     * @return si il existe une liste de pays ou non
     */
    @Override
    public boolean ListPaysExist(Map<String,String> arg) {
        
        String sql = "select count(*) from pays.pays where libelle_fr like ? " ;   
        StringBuilder bsql = new StringBuilder(sql);
        
        Object[] obj = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<Object>(Arrays.asList(obj));               
        if(arg.containsKey("libelle")){
            newObj.add(arg.get("libelle")+"%");            
        }
        else newObj.add("%");
        
        if(arg.containsKey("indicatif")){
            newObj.add(arg.get("indicatif")+"%"); 
            bsql.append("and indicatif like ?");
        }
        
        if(arg.containsKey("monnaie_code")){
            newObj.add(arg.get("monnaie_code")+"%"); 
            bsql.append("and monnaie_code like ?");
        }
        
        if(arg.containsKey("danger")){
            if((arg.get("danger")=="true")||(arg.get("danger")=="1")){
                newObj.add("1");
            }
            else newObj.add("0");
   
            bsql.append("and danger = ?");
        }
        
        if(arg.containsKey("monnaie_perdiem")){
            newObj.add(arg.get("monnaie_perdiem"));
            if(arg.containsKey("monnaie_perdiem_arg")){
                 
                switch (arg.get("monnaie_perdiem_arg")){
                    case "+":
                        bsql.append("and monnaie_perdiem >= ?");
                        break;
                    case "-":
                        bsql.append("and monnaie_perdiem <= ?");
                        break;
                    default:
                        bsql.append("and monnaie_perdiem = ?");                         
                }
            }
            else bsql.append("and monnaie_perdiem = ?");                     
        }
        
        if(arg.containsKey("taux_change")){
            newObj.add(arg.get("taux_change"));
            if(arg.containsKey("taux_change_arg")){
                 
                switch (arg.get("taux_change_arg")){
                    case "+":
                        bsql.append("and taux_change >= ?");
                        break;
                    case "-":
                        bsql.append("and taux_change <= ?");
                        break;
                    default:
                        bsql.append("and taux_change = ?");                         
                }
            }
            else bsql.append("and taux_change = ?");                     
        }
 
        sql = bsql.toString();
        
       
        int count = jdbcTemplate.queryForInt(sql,newObj.toArray());
        return count > 0 ? true : false;
    }
}
