package exceptions;

/**
 * Classe d'exception pour les pays non trouvé
 * @author Blax
 */
public class PaysNotFoundException extends Exception{

    public PaysNotFoundException(){
        System.out.println("Pays non trouvé");
    }
}
