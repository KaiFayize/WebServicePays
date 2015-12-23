<?php
	/*
	* Ce fichier permet d'afficher la liste des pays grâce à l'appel soap et la méthode getAllPaysName
	* Afin de la mettre dans dans une balise selection pour faire un choix de pays
	*
	*
	*
	* Dans le cas où cela n'affiche rien: 
	* Regarder si soap est activé dans le serveur. 
	* Soit directement chercher phpinfo ou bien créer un fichier php contenant le code suivant:
	*<?php
	* echo phpinfo();
	*?> 
	* Puis chercher soap. Dans le cas où soap n'est pas encore activé dans phpinfo, 
	* Etape 1: Chercher le fichier php.ini.
	* Etape 2: Ouvrir le fichier , puis cherchez soap.
	* Etape 3: Decommenter la ligne où se trouve soap c'est-à-dire enlevez le point-virgule ";". 
	* Etape 4: Enregistrer puis relancer phpinfo
	*Maintenant soap pour php est activé.
	*
	*
	* PHP version 4 et 5
	*  
	*@author	Gisio TABERA RANDRIAMANANTSOA
	*@copyright	2015	The Etamine Groupe
	*@date:		
	*/
	
	
	/*
	* Permet de resoudre le problème d'accent
	*/
	mb_internal_encoding('UTF-8');
		
	
	/*On doit evite la mise en cache du WSDL. Qui se fait tout les 24h
	la fonction ini_set() avec la constante prédéfinit soap.wsdl_cache_enabled
	nous permettre de faire cette manipulation.
	*/
		
	ini_set('soap.wsdl_cache_enabled', 0);

	/*
	La création d'un client soap se fait par l'appel de SoapClient.
	SoapClient() prend en parametre l'adresse de l'emplacement du fichier
	wsdl et un tableau.
	*/
		
	
	$service =  new SoapClient("http://localhost:8080/ws/pays.wsdl",array("trace" => 1, "exception" => 0));
		try{
			/*
			* Utilisation de la méthode getAllPaysName du web service pour générer la liste des pays par rapport à la base de données.
			*@return liste des pays.
			*/
				$liste_pays = $service->getAllPaysName(); 	
				foreach ($liste_pays->paysNom as $key => $value) 
				{
					echo '<option value="';
					print_r(($value));
					echo '">';
					print_r(($value));
					echo' </option>';
				}
			
		}catch(SoapFault $fault){
			echo "Error: ",$fault->faultcode,", string: ",$fault->faultstring;
		}	
   
?>