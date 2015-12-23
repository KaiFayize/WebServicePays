/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsconfig;

import io.spring.guides.gs_producing_web_service.GetAllPaysDangerRequest;
import io.spring.guides.gs_producing_web_service.GetAllPaysDangerResponse;
import io.spring.guides.gs_producing_web_service.GetAllPaysNameRequest;
import io.spring.guides.gs_producing_web_service.GetAllPaysNameResponse;
import io.spring.guides.gs_producing_web_service.GetAllPaysRequest;
import io.spring.guides.gs_producing_web_service.GetAllPaysResponse;
import io.spring.guides.gs_producing_web_service.GetListPaysRequest;
import io.spring.guides.gs_producing_web_service.GetListPaysResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetPaysRequest;
import io.spring.guides.gs_producing_web_service.GetPaysResponse;
import java.util.HashMap;

/**
 * Endpoint du Web Services ou sont defini les methodes accesibles aux client
 * 
 */
@Endpoint
public class PaysEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private PaysRepository paysRepository;

    @Autowired
    public PaysEndpoint(PaysRepository paysRepository) {
        this.paysRepository = paysRepository;
    }
    
    /**
     * Renvoye la reponse qui corresponds à la requete getPaysRequest
     * @param request Une requete getPaysRequest qui contient un libelle
     * @return La reponse qui possede le Pays associé au libelle de la requete reçu
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaysRequest")
    @ResponsePayload
    public GetPaysResponse getPays(@RequestPayload GetPaysRequest request) {
        GetPaysResponse response = new GetPaysResponse();
        response.setPays(paysRepository.findPays(request.getLibelle()));
        return response;
    }
    
    /**
     * Renvoye la reponse qui corresponds à la requete getAllPaysNameRequest
     * @param request Une requete getAllPaysNameRequest
     * @return La reponse qui possede la liste de libelle de tout les pays.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPaysNameRequest")
    @ResponsePayload
    public GetAllPaysNameResponse getAllPaysName(@RequestPayload GetAllPaysNameRequest request) {
        GetAllPaysNameResponse response = new GetAllPaysNameResponse();
        response.getPaysNom().addAll(paysRepository.findAllPaysName());
        return response;
    }
    
    /**
     * Renvoye la reponse qui corresponds à la requete getAllPaysRequest
     * @param request Une requête getAllPaysRequest
     * @return La réponse qui possède la liste de tout les pays
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPaysRequest")
    @ResponsePayload
    public GetAllPaysResponse getAllPays(@RequestPayload GetAllPaysRequest request) {
        GetAllPaysResponse response = new GetAllPaysResponse();
        response.getPays().addAll(paysRepository.findAllPays());
        return response;
    }    
    
    /**
     * Renvoye la reponse qui corresponds à la requete getAllPaysDangerRequest
     * @param request Une requête getAllPaysDangerRequest qui contient un boolean
     * @return La réponse qui possède la liste de tout les pays en danger ou non
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPaysDangerRequest")
    @ResponsePayload
    public GetAllPaysDangerResponse getAllPaysDanger(@RequestPayload GetAllPaysDangerRequest request) {
        GetAllPaysDangerResponse response = new GetAllPaysDangerResponse();
        response.getPays().addAll(paysRepository.findAllPaysDanger(request.isDanger()));
        return response;
    }    
    
    
    /**
     * Renvoye la reponse qui corresponds à la requete getListPaysRequest
     * @param request Une requête getListPaysRequest qui contient plusieurs arguments
     * @return La réponse qui possède la liste de tout les pays en danger ou non
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListPaysRequest")
    @ResponsePayload
    public GetListPaysResponse getListPays(@RequestPayload GetListPaysRequest request) {
        GetListPaysResponse response = new GetListPaysResponse();
 
        HashMap<String,String> arg = new HashMap();
        if(request.getLibelle() != null) arg.put("libelle", request.getLibelle()); 
        if(request.getIndicatif()!= null) arg.put("indicatif", request.getIndicatif());
        if(request.isDanger() != null) { arg.put("danger", request.isDanger().toString()); System.out.println(request.isDanger()); }
        if(request.getMonnaieCode() != null) arg.put("monnaie_code", request.getMonnaieCode());
        if(request.getMonnaiePerdiem()!=null) arg.put("monnaie_perdiem", request.getMonnaiePerdiem().toString());
        if(request.getMonnaiePerdiemArg()!=null) arg.put("monnaie_perdiem_arg", request.getMonnaiePerdiemArg());    
        if(request.getTauxChange()!=null) arg.put("taux_change", request.getTauxChange().toString());
        if(request.getTauxChangeArg()!=null) arg.put("taux_change_arg", request.getTauxChangeArg());
    
        
        response.getPays().addAll(paysRepository.findListPays(arg));
        return response;
    }    
    
}
