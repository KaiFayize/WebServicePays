package exceptions;

/**
 * Classe d'exception pour les pays non trouvé
 * @author Blax
 */
public class UserNotFoundException extends Exception{

    public UserNotFoundException(){
        System.out.println("User not found");
    }
}
