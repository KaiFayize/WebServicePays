
package clientconfig;


import java.util.HashMap;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import pays.wsdl.GetAllPaysNameRequest;
import pays.wsdl.GetAllPaysNameResponse;
import java.util.List;
import pays.wsdl.GetAllPaysDangerRequest;
import pays.wsdl.GetAllPaysDangerResponse;
import pays.wsdl.GetAllPaysRequest;
import pays.wsdl.GetAllPaysResponse;
import pays.wsdl.GetPaysRequest;
import pays.wsdl.GetPaysResponse;
import pays.wsdl.GetListPaysRequest;
import pays.wsdl.GetListPaysResponse;
        
import pays.wsdl.Pays;


/**
 * PaysClient est la classe ou sont défini les methode qui intéragisse avec le web services
 * 
 */
public class PaysClient extends WebServiceGatewaySupport {
        Config config;

    public Config getConfig() {
        return config;
    }
        
        
        public void setConfig(Config cfg){
            config = cfg;
            
        }
        /**
         * Renvoie la reponse à la requete getAllPaysNameRequest
         * @return Une reponse contenant la liste de nom de tout les pays
         */
        public GetAllPaysNameResponse getAllPaysNameRequest(){
            GetAllPaysNameRequest request = new GetAllPaysNameRequest();
            
            System.out.println("Requesting all name");   
            
            GetAllPaysNameResponse response = (GetAllPaysNameResponse) getWebServiceTemplate().marshalSendAndReceive(
				request,
				new SoapActionCallback(config.getDefaultUri() + config.getContextPath() +
						/*"http://localhost:8080/ws/pays.wsdl*/"?getAllPaysNameRequest"));
            
            return response;
        }
        
        /**
         * Renvoie la réponse correspondant à la requete getAllPaysRequest
         * @return une réponse qui contient la liste de tout les pays
         */
        public GetAllPaysResponse getAllPaysRequest(){
            GetAllPaysRequest request = new GetAllPaysRequest();
            
            System.out.println("Requesting all pays");   
            
            GetAllPaysResponse response = (GetAllPaysResponse) getWebServiceTemplate().marshalSendAndReceive(
				request,
				new SoapActionCallback(config.getDefaultUri() + config.getContextPath() +
						/*"http://localhost:8080/ws/pays.wsdl*/"?getAllPaysRequest"));
            
            return response;
        }
        
        public GetAllPaysDangerResponse getAllPaysDangerRequest(boolean danger){
            GetAllPaysDangerRequest request = new GetAllPaysDangerRequest();
            request.setDanger(danger);
            
            System.out.println("Requesting all pays where danger = "+danger);   
            
            GetAllPaysDangerResponse response = (GetAllPaysDangerResponse) getWebServiceTemplate().marshalSendAndReceive(
				request,
				new SoapActionCallback(config.getDefaultUri() + config.getContextPath() +
						/*"http://localhost:8080/ws/pays.wsdl*/"?getAllPaysDangerRequest"));
            
            return response;
        }
                
        /**
         * Renvoie la réponse correspondant à la requete getPaysRequest
         * @param libelle nom du pays que l'on veut obtenir
         * @return une réponse qui contient le pays demandé
         */
        public GetPaysResponse getPaysRequest(String libelle){
            GetPaysRequest request = new GetPaysRequest();
            request.setLibelle(libelle);
            
            System.out.println("Requesting " + libelle);   
            
            GetPaysResponse response = (GetPaysResponse) getWebServiceTemplate().marshalSendAndReceive(
				request,
				new SoapActionCallback(config.getDefaultUri() + config.getContextPath() +
						/*"http://localhost:8080/ws/pays.wsdl*/"?getPaysRequest"));
            
            return response;
        }
        
     /**
     * Renvoie la réponse correspondant à la requete getPaysRequest
     * @param arg nom du pays que l'on veut obtenir
     * @return une réponse qui contient le pays demandé
     */
        public GetListPaysResponse getListPaysRequest(HashMap<String,String> arg){
            GetListPaysRequest request = new GetListPaysRequest();
            //request.setLibelle(libelle);
            
        if(arg.containsKey("libelle")){ 
            request.setLibelle(arg.get("libelle"));
            System.out.println("Requesting " + arg.get("libelle"));
        }
        if(arg.containsKey("indicatif")){ 
            request.setIndicatif(arg.get("indicatif"));
            System.out.println("Requesting " + arg.get("indicatif"));
        }    
        
        if(arg.containsKey("monnaie_code")){ 
            request.setMonnaieCode(arg.get("monnaie_code"));
            System.out.println("Requesting " + arg.get("monnaie_code"));
        }  
        
        if(arg.containsKey("danger")){
            if((arg.get("danger")=="true")||(arg.get("danger")=="1")){
                request.setDanger(true);
                System.out.println("Requesting " + true );
            }
            else {
                request.setDanger(false);
                System.out.println("Requesting " + false );    
            }            
        }
        
                
        if(arg.containsKey("monnaie_perdiem")){
            request.setMonnaiePerdiem(Float.parseFloat(arg.get("monnaie_perdiem")));
            System.out.print("Requesting: " + arg.get("monnaie_perdiem") );
            if(arg.containsKey("monnaie_perdiem_arg")){
                request.setMonnaiePerdiemArg(arg.get("monnaie_perdiem_arg"));                 
                switch (arg.get("monnaie_perdiem_arg")){
                    case "+":
                        System.out.println(" >= ");
                        break;
                    case "-":
                        System.out.println(" <= ");
                        break;
                    default:
                        System.out.println(" = ");                         
                }
            }
            else System.out.println(" = ");                     
        }
        
          if(arg.containsKey("taux_change")){
            request.setTauxChange(Float.parseFloat(arg.get("taux_change")));
            System.out.print("Requesting: " + arg.get("taux_change") );
            if(arg.containsKey("taux_change_arg")){
                request.setTauxChangeArg(arg.get("taux_change_arg"));                 
                switch (arg.get("taux_change_arg")){
                    case "+":
                        System.out.println(" >= ");
                        break;
                    case "-":
                        System.out.println(" <= ");
                        break;
                    default:
                        System.out.println(" = ");                         
                }
            }
            else System.out.println(" = ");                     
        }
            
            
            
            GetListPaysResponse response = (GetListPaysResponse) getWebServiceTemplate().marshalSendAndReceive(
				request,
				new SoapActionCallback(config.getDefaultUri() + config.getContextPath() +
						/*"http://localhost:8080/ws/pays.wsdl*/"?getListPaysRequest"));
            
            return response;
        }
        
        /**
         * Affiche le nom de tout les pays
         * @param response une réponse contenant la liste de nom de tout les pays
         */
	public void printResponse(GetAllPaysNameResponse  response) {
            List<String> list = response.getPaysNom();
            
            for (String pays : list) {
                System.out.println("libelle : " +pays);

            }
        }
        
        /**
         * Affiche les données d'une liste de pays
         * @param response une réponse contenant une liste de pays
         */
	public void printResponse(GetAllPaysResponse  response) {
            List<Pays> list = response.getPays();
            
            for (Pays pays : list) {
                printPays(pays);
            }

	}
        
        /**
         * Affiche les données d'une liste de pays
         * @param response une réponse contenant une liste de pays
         */
        public void printResponse(GetListPaysResponse  response) {
            List<Pays> list = response.getPays();
            
            for (Pays pays : list) {
                printPays(pays);
            }

	}
        
        /**
         * Affiche les données d'une liste de pays
         * @param response une réponse contenant une liste de pays
         */
        public void printResponse(GetAllPaysDangerResponse  response) {
            List<Pays> list = response.getPays();
            
            for (Pays pays : list) {
                printPays(pays);
            }
            
	}
        
        /**
         * Affiche les donnée d'un pays
         * @param response une réponse contenant un pays
         */
	public void printResponse(GetPaysResponse  response) {
            Pays pays = response.getPays();
            printPays(pays);
        }
        
        /**
         * Affiche les info d'un pays
         * @param pays Pays a afficher
         */    
        private void printPays(Pays pays){
           System.out.println(
                    " [  ID: " + pays.getID() + 
                    ", indicatif: " + pays.getIndicatif() + 
                    ", libelle_Fr: " +pays.getLibelleFr() +
                    ", libelle_En: " +pays.getLibelleEn() + 
                    ", nationalite: " +pays.getNationalite() + 
                    ", monnaie code: " + pays.getMonnaieCode() +                          
                    ", monnaie perdiem: " + pays.getMonnaiePerdiem() + 
                    ", taux de change: " + pays.getTauxChange() +
                    ", danger: "   + pays.isDanger() + "  ]");
        }

}
