package metier;

import entite.User;
import exceptions.UserNotFoundException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainHandler {
        private User currentUser;
	/**
	 * Create a new player if he doesn't exist
	 * 
	 * @param login
	 * @param password
         * @throws exceptions.UserNotFoundException
	 */
	public MainHandler(String login, String password) throws UserNotFoundException{
	/* Connection to DB */
        ListableBeanFactory bf;
        bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        IPaysMetier instance = (IPaysMetier)bf.getBean("paysMetier");
        System.out.println("Bean créé on test le user");
        
        User u = instance.findUser(login);
		if(u == null){
			//MessageDigest md = MessageDigest.getInstance("MD5");
			//System.out.println("Le tableau de byte obtenue est "+pass.hashCode());
			//System.out.println("Le tableau de byte obtenue est +"+pass.getBytes("UTF-8"));
			//System.out.println("Le tableau de byte obtenue est +"+pass.getBytes("ISO-8859-1"));
			//md.update(pass.getBytes("UTF-8"));
                        System.out.println("le user n'existe pas");
                        
			//byte[] md5 = md.digest();
			//addPlayer(firstname, lastname, String.valueOf(pass.hashCode()));
			//currentPlayer  = playerHandler.getPlayerByName(firstname, lastname);	
			//System.out.println("Le mot de passe de base est ["+pass+"], le md5 = ["+md5.toString()+"] ");	
		}else{
			if(checkPassword(u, password)){
				currentUser = u;
				System.out.println("User "+u.getUser()+" is now connected");
                                System.out.println("User pw :"+u.getPassword()+"\n User rank : "+u.getRank());
			}else{
				currentUser = null;
			}
			
		}

	}
	
	/* ================ */
	/* =FOR THE PLAYER= */
	/* ================ */
	
	private boolean checkPassword(User u, String pass){
		//MessageDigest md = MessageDigest.getInstance("MD5");
		//md.update(pass.getBytes("UTF-8"));
		//byte[] md5 = md.digest();
		System.out.println("Le mot de passe de base est ["+String.valueOf(pass.hashCode())+"], le mot de passe BDD est  = "+u.getPassword()+"]");
		return String.valueOf(pass.hashCode()).equals(u.getPassword());
	}
	
	/**
	 * return the current Player
	 * @return Player
	 */
	public User getCurrentUser(){
		return currentUser;
	}
}	