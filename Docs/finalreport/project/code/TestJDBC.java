
import entite.Pays;
import exceptions.PaysNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import metier.IPaysMetier;
import entite.User;
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

            System.out.println("libelle : " + pays.getIndicatif());
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
        
        String libelle = "france";
        try{
            Pays result = instance.findPays(libelle);
            System.out.println("libelle : " +result.getLibelleFr());
        }
        catch (PaysNotFoundException e){
            e.printStackTrace();
        }
    }        
           
        @Test
    public void testFindUser() throws Exception {                
        System.out.println("Test findUser");
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        String user = "test";
        
        User result = instance.findUser(user);
        System.out.println("Login : " +result.getUser());
        System.out.println("Password : " +result.getPassword());
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
        arg.put("libelle", "faaaaa%");
        arg.put("danger", "false");
        List<Pays> result = instance.findListPays(arg);
        for (Pays pays : result) {

            System.out.println("libelle : " + pays.getLibelleFr());
        } 
    }
    
    @Test
        public void testCreatePays() throws Exception {
        System.out.println("createPays");
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        Map<String,String> arg = new HashMap();
        arg.put("ID", "243");
        arg.put("libelle_fr", "atest");
        arg.put("indicatif", "aat2");
        arg.put("monnaie_perdiem", "14");
        arg.put("taux_change", "1");
        instance.createPays(arg);
    }
        
        @Test
    public void testDeletePays() throws Exception {
        System.out.println("deletePays");
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        
        instance.deletePays("atest6");
    }
    
    @Test
    public void testUpdatePays() throws Exception {
        System.out.println("updatePays");
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        
        Map<String,String> arg = new HashMap();
        //arg.put("libelle", "atest6super");
        arg.put("indicatif", "attse");
        arg.put("monnaie_perdiem", "239");
        arg.put("nationalite", "atestiens");
        arg.put("monnaie_code", "ATTdT");
        arg.put("libelle_en", "aitef");
        arg.put("libelle_fr", "atest6");
        arg.put("drapeau", "random_drapeau.png");
        instance.updatePays("atest66", arg);
    }

    
}
