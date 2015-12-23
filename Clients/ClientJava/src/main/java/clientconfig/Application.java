
package clientconfig;

import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import pays.wsdl.GetAllPaysNameResponse;
import pays.wsdl.GetAllPaysResponse;
import pays.wsdl.GetListPaysResponse;
import pays.wsdl.GetPaysResponse;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PaysConfiguration.class, args);

                PaysClient paysClient = ctx.getBean(PaysClient.class);
                
                HashMap<String,String> arg = new HashMap();
                arg.put("libelle", "fr"); 
                //arg.put("danger", "1");
                //arg.put("monnaie_code", "e");
                //arg.put("taux_change", "0.5");
                //arg.put("taux_change_arg", "+");
                GetListPaysResponse response = paysClient.getListPaysRequest(arg);
		paysClient.printResponse(response);
	}

}
