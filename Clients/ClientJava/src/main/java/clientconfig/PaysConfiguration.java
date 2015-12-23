
package clientconfig;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * PaysConfiguration est la classe qui configure le client
 * @author Blax
 */
@Configuration
public class PaysConfiguration {
        
        /**
         * Permet de generer les classes nécesaire pour utiliser le web service
         * @return un marshaller
         */
	@Bean
	public Jaxb2Marshaller marshaller() {
                ClassPathResource cpr=new ClassPathResource("applicationContextClient.xml");

   
                ListableBeanFactory bf = new XmlBeanFactory(cpr);
                Config conf = (Config) bf.getBean("config");
                
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		//marshaller.setContextPath("pays.wsdl");
                
                marshaller.setContextPath(conf.getContextPath());
		return marshaller;
	}

        /**
         * Renvoie un PaysClient
         * @param marshaller un marshaller
         * @return un PaysClient lié au web service
         */
	@Bean
	public PaysClient paysClient(Jaxb2Marshaller marshaller) {
                ClassPathResource cpr=new ClassPathResource("applicationContextClient.xml");

   
                ListableBeanFactory bf = new XmlBeanFactory(cpr);
                Config conf = (Config) bf.getBean("config");
            
		PaysClient client = new PaysClient();
		//client.setDefaultUri("http://localhost:8080/ws/");
                client.setDefaultUri(conf.getDefaultUri());
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
                
                client.setConfig(conf);
		return client;
	}

}
