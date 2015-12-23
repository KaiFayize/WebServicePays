package dao;

import entite.Pays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import entite.User;
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
    public boolean paysExiste(String nom) {
        String sql="select count(*) from pays.pays where libelle_fr=?";
        int count=jdbcTemplate.queryForInt(sql,new Object[]{nom});
        return count > 0 ? true : false;
    }
    
    public boolean userExiste(String nom) {
        String sql="select count(*) from pays.users where user=?";
        int count=jdbcTemplate.queryForInt(sql,new Object[]{nom});
        return count > 0 ? true : false;
    }
    
    /**
     * Renvoie la liste de tous les pays de la base de donnée
     * @return La liste de tout les pays
     */
    public List findAllPays() {
        String sql="select * from pays";   
        List<Pays> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Pays.class));
        return list;
    }

    
    /**
     * Renvoie un pays
     * @param nom le nom du pays cherché
     * @return Le pays trouvé
     */
    public Pays findPays(String nom) {
        String sql = "select *from pays.pays WHERE libelle_fr = ?" ;
       
        Pays pays = (Pays)jdbcTemplate.queryForObject(
			sql, new Object[] { nom }, 
			new BeanPropertyRowMapper(Pays.class)); 
        
        return pays;
    }
    
    
    public User findUser(String user) {
        String sql = "select * from pays.users WHERE user = ?" ;
        
        User currentuser = (User)jdbcTemplate.queryForObject(
			sql, new Object[] { user }, 
			new BeanPropertyRowMapper(User.class)); 
        
        return currentuser;
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
     * @param arg HashMap qui peut contenir des valeurs avec les clés suivante pour construir une requete:
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
        
        String sql = "select *from pays.pays where libelle like ? " ;   
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
     @param arg HashMap qui peut contenir des valeurs avec les clés suivante pour construir une requete:
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
        
        String sql = "select count(*) from pays.pays where libelle like ? " ;   
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
    
    public void deletePays(String nom) {
         
        String sql = "delete from pays.pays where libelle_fr = ?";
        jdbcTemplate.update(sql, nom);
 
    }

    public int updatePays(String libelle, Map<String, String> arg) { 
        String sql="update pays.pays set libelle_fr=?";
              
        StringBuilder bsql = new StringBuilder(sql);
        
        Object[] obj = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<Object>(Arrays.asList(obj));               
        if(arg.containsKey("libelle_fr")){
            newObj.add(arg.get("libelle_fr"));            
        }
        else newObj.add(libelle);

        if(arg.containsKey("libelle_en")){
            newObj.add(arg.get("libelle_en")); 
            bsql.append(", libelle_en = ?");
        }
        

        if(arg.containsKey("nationalite")){
            newObj.add(arg.get("nationalite")); 
            bsql.append(", nationalite = ?");
        }
              
        
        if(arg.containsKey("indicatif")){
            newObj.add(arg.get("indicatif")); 
            bsql.append(", indicatif = ?");
        }
        
        if(arg.containsKey("monnaie_code")){
            newObj.add(arg.get("monnaie_code")); 
            bsql.append(", monnaie_code = ?");
        }
        
        if(arg.containsKey("danger")){
            if((arg.get("danger")=="true")||(arg.get("danger")=="1")){
                newObj.add("1");
            }
            else newObj.add("0");
   
            bsql.append(", danger = ?");
        }
        
        if(arg.containsKey("drapeau")){
            newObj.add(arg.get("drapeau")); 
            bsql.append(", drapeau = ?");
        }       
        
        if(arg.containsKey("monnaie_perdiem")){
            newObj.add(arg.get("monnaie_perdiem"));
            
            bsql.append(", monnaie_perdiem = ? ");                     
        }
        
        if(arg.containsKey("taux_change")){
            newObj.add(arg.get("taux_change"));
            bsql.append(", taux_change = ?");                     
        }
        newObj.add(libelle);
        bsql.append("where libelle_fr = ?");
        
        sql = bsql.toString();
         
        return jdbcTemplate.update(sql,newObj.toArray());
    }

    @Override
    public void createPays(Map<String, String> arg) {
        String sql = "insert into pays.pays (ID, indicatif, nationalite, libelle_en, libelle_fr, monnaie_code, monnaie_perdiem, taux_change, danger, drapeau, coords1, coords2, coords3, coords4, coords5) values (?,?,?,?,?,?,?,?,?,?, '','','','','')";
            
        Object[] obj = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<Object>(Arrays.asList(obj));               
        
        if(arg.containsKey("ID")){
            newObj.add(arg.get("ID"));            
        }
        else newObj.add(null);
        
        if(arg.containsKey("indicatif")){
            newObj.add(arg.get("indicatif"));            
        }
        else newObj.add("");
        
        if(arg.containsKey("nationalite")){
            newObj.add(arg.get("nationalite"));            
        }
        else newObj.add("");
        
        if(arg.containsKey("libelle_en")){
            newObj.add(arg.get("libelle_en"));            
        }
        else newObj.add("");
        
        if(arg.containsKey("libelle_fr")){
            newObj.add(arg.get("libelle_fr"));            
        }
        else newObj.add("");
        
        if(arg.containsKey("monnaie_code")){
            newObj.add(arg.get("monnaie_code"));            
        }
        else newObj.add("");
   
        if(arg.containsKey("monnaie_perdiem")){
            newObj.add(arg.get("monnaie_perdiem"));            
        }
        else newObj.add("0");
        
        if(arg.containsKey("taux_change")){
            newObj.add(arg.get("taux_change"));            
        }
        else newObj.add("0");
        
        if(arg.containsKey("danger")){
            if((arg.get("danger")=="true")||(arg.get("danger")=="0")){
                newObj.add("1");
            }
            else newObj.add("0");   
        }
        else newObj.add("0");
        
        if(arg.containsKey("drapeau")){
            newObj.add(arg.get("drapeau"));            
        }
        else newObj.add("");
       
        
        jdbcTemplate.update( sql, newObj.toArray());
        return;
    }
    
}
