/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconfig;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import pays.wsdl.GetAllPaysDangerResponse;
import pays.wsdl.GetAllPaysNameResponse;
import pays.wsdl.GetAllPaysResponse;
import pays.wsdl.GetListPaysResponse;
import pays.wsdl.GetPaysResponse;

/**
 *
 * @author Blax
 */
public class PaysClientTest {
    
    public PaysClientTest() {
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
     * Test of getAllPaysNameRequest method, of class PaysClient.
     */
    @Test
    public void testGetAllPaysNameRequest() {
        System.out.println("getAllPaysNameRequest");
            ApplicationContext ctx = SpringApplication.run(PaysConfiguration.class);

            PaysClient paysClient = ctx.getBean(PaysClient.class);

            GetAllPaysNameResponse response = paysClient.getAllPaysNameRequest();
            paysClient.printResponse(response);       
    }

    /**
     * Test of getAllPaysRequest method, of class PaysClient.
     */
    @Test
    public void testGetAllPaysRequest() {
        System.out.println("getAllPaysRequest");
            ApplicationContext ctx = SpringApplication.run(PaysConfiguration.class);

            PaysClient paysClient = ctx.getBean(PaysClient.class);

            GetAllPaysResponse response = paysClient.getAllPaysRequest();
            paysClient.printResponse(response);       
    }
    
    /**
     * Test of getAllPaysDangerRequest method, of class PaysClient.
     */
    @Test
    public void testGetAllPaysDangerRequest() {
        System.out.println("getAllPaysRequest");
            ApplicationContext ctx = SpringApplication.run(PaysConfiguration.class);

            PaysClient paysClient = ctx.getBean(PaysClient.class);

            GetAllPaysDangerResponse response = paysClient.getAllPaysDangerRequest(true);
            paysClient.printResponse(response);       
    }
    
    /**
     * Test of getPaysRequest method, of class PaysClient.
     */
    @Test
    public void testGetPaysRequest() {
        System.out.println("getPaysRequest");
            ApplicationContext ctx = SpringApplication.run(PaysConfiguration.class);

            PaysClient paysClient = ctx.getBean(PaysClient.class);

            GetPaysResponse response = paysClient.getPaysRequest("france");
            paysClient.printResponse(response);
            response = paysClient.getPaysRequest("albanie");
            paysClient.printResponse(response);                
    }

    /**
     * Test of getListPaysRequest method, of class PaysClient.
     */
    @Test
    public void testGetListPaysRequest() {
        System.out.println("getListPaysRequest");
            ApplicationContext ctx = SpringApplication.run(PaysConfiguration.class);

            PaysClient paysClient = ctx.getBean(PaysClient.class);

            HashMap<String,String> arg = new HashMap();
            arg.put("libelle", "a"); 
            arg.put("danger", "false");
            arg.put("monnaie_code", "e");
            arg.put("taux_change", "0.5");
            arg.put("taux_change_arg", "+");
            arg.put("monnaie_perdiem", "100");
            arg.put("monnaie_perdiem_arg", "+");
            
            GetListPaysResponse response = paysClient.getListPaysRequest(arg);
            paysClient.printResponse(response);          
    }
}
