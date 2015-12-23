
package wsconfig;

/**
 * WsConfig est la classe qui contient les paramettres nécessaire a la configuration du Web Service
 * 
 */
public class WsConfig {
    private String portTypeName;
    private String locationUri;
    private String targetNamespace;
    private String schema;

    	// Methodes appelees lors de l'initialisation/suppression du bean
	public void init() {
		//System.out.println("init voiture [" + this.toString() + "]");
	}
	public void close() {
		//System.out.println("destroy voiture [" + this.toString() + "]");
	}
    public String getPortTypeName() {
        return portTypeName;
    }

    public void setPortTypeName(String portTypeName) {
        this.portTypeName = portTypeName;
    }

    public String getLocationUri() {
        return locationUri;
    }

    public void setLocationUri(String locationUri) {
        this.locationUri = locationUri;
    }

    public String getTargetNamespace() {
        return targetNamespace;
    }

    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "WsConfig{" + "portTypeName=" + portTypeName + ", locationUri=" + locationUri + ", targetNamespace=" + targetNamespace + ", schema=" + schema + '}';
    }
    
   
}
