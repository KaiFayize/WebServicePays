/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsconfig;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
/**
 * WebServiceConfigPays est la classe qui définis les parametres d'acces au web services
 * 
 */
@EnableWs
@Configuration
public class WebServiceConfigPays extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
                                   
                ClassPathResource cpr=new ClassPathResource("applicationContext.xml");  
                ListableBeanFactory bf = new XmlBeanFactory(cpr);
                WsConfig conf = (WsConfig) bf.getBean("config");
            
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		/*return new ServletRegistrationBean(servlet, "/ws/*");*/
                return new ServletRegistrationBean(servlet, conf.getLocationUri() +"/*");
	}

	@Bean(name = "pays")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema paysSchema) {
            
                ClassPathResource cpr=new ClassPathResource("applicationContext.xml");  
                ListableBeanFactory bf = new XmlBeanFactory(cpr);
                WsConfig conf = (WsConfig) bf.getBean("config");
                     
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		/*wsdl11Definition.setPortTypeName("PaysPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");*/
                
                wsdl11Definition.setPortTypeName(conf.getPortTypeName());
		wsdl11Definition.setLocationUri(conf.getLocationUri());
		wsdl11Definition.setTargetNamespace(conf.getTargetNamespace());
		wsdl11Definition.setSchema(paysSchema);
		return wsdl11Definition;
	}

              
	@Bean
	public XsdSchema countriesSchema() {
                ClassPathResource cpr=new ClassPathResource("applicationContext.xml");
   
                ListableBeanFactory bf = new XmlBeanFactory(cpr);
                WsConfig conf = (WsConfig) bf.getBean("config");
            
		//return new SimpleXsdSchema(new ClassPathResource("pays.xsd"));
                return new SimpleXsdSchema(new ClassPathResource(conf.getSchema()));
	}
}