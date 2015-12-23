
package clientconfig;

/**
 *
 * Config est la classe qui contient les paramettre pour configurer le client
 */
public class Config {

    private String defaultUri;
    private String contextPath;
    
        // Methodes appelees lors de l'initialisation/suppression du bean
    public void init() {
            //System.out.println("init voiture [" + this.toString() + "]");
    }
    public void close() {
            //System.out.println("destroy voiture [" + this.toString() + "]");
    }   
    
    public String getDefaultUri() {
        return defaultUri;
    }

    public void setDefaultUri(String defaultUri) {
        this.defaultUri = defaultUri;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
    


}
