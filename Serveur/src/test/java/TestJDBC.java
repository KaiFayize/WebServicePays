
import io.spring.guides.gs_producing_web_service.Pays;
import exceptions.PaysNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import metier.IPaysMetier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class TestJDBC {
    
    public TestJDBC() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAllPays method, of class IPaysMetier.
     */
    @Test
    public void testFindAllPays() throws Exception {
        System.out.println("findAllPays");
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        List<Pays> result = instance.findAllPays();
        for (Pays pays : result) {

            System.out.println("libelle : " + pays.getLibelleEn());
        } 
    }

    /**
     * Test of findPays method, of class IPaysMetier.
     */
    @Test
    public void testFindPays() throws Exception {                
        System.out.println("Test findPays");
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        String libelle = "bolivie";
        int id = 105;
        try{
            Pays result = instance.findPays(id);
            System.out.println("libelle : " +result.getLibelleFr() + result.getID());
        }
        catch (PaysNotFoundException e){
            e.printStackTrace();
        }
    }        
           
    
     /**
     * Test of findAllPays method, of class IPaysMetier.
     */
    @Test
    public void testFindAllPaysDanger() throws Exception {
        System.out.println("findAllPaysDanger");
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        List<Pays> result = instance.findAllPaysDanger(true);
        for (Pays pays : result) {

            System.out.println("libelle : " + pays.getLibelleFr());
        } 
    }
    
         /**
     * Test of findAllPays method, of class IPaysMetier.
     */
    @Test
    public void testFindAllPaysList() throws Exception {
        System.out.println("findAllPaysList");
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        Map<String,String> arg = new HashMap();
        //arg.put("libelle", "i");
        ///arg.put("danger", "0");
        //arg.put("monnaie_perdiem", "180");
        //arg.put("monnaie_perdiem_arg", "-");
        //arg.put("indicatif", "i");
        //arg.put("taux_change", "1");
        //arg.put("taux_change_arg", "+");
        arg.put("monnaie_code", "e");
        List<Pays> result = instance.findListPays(arg);
        for (Pays pays : result) {

            System.out.println("libelle : " + pays.getLibelleFr());
        }
        System.out.println(result.size());
    }

    
}
