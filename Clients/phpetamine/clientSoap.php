<?php
	/*
	* Ce fichier est le code source du client en soap pour le web service Etamine.
	* Elle permet d'afficher le résultat que l'utilisateur du site veut avoir comme:
	* le code iso, le libellé, le nom du pays en français ou en anglais, les coordonées
	* géographiques, la monnaie, le drapeau et le taux de risque dans un pays.
	*
	* Dans le cas où ça n'affiche rien: 
	* Regarder si soap est activé dans le serveur. 
	* Soit directement chercher phpinfo ou bien créer un fichier php contenant le code suivant:
	*<?php
	* echo phpinfo();
	*?> 
	* Puis chercher soap. Dans le cas où soap n'est pas encore activé dans phpinfo, 
	* Etape 1: Chercher le fichier php.ini;
	* Etape 2: Ouvrir le fichier , puis chercher soap;
	* Etape 3: Decommenter la ligne où se trouve soap c'est-à-dire enlever le point-virgule ";" 
	* Etape 4: Enregistrer puis relancer phpinfo
	* Maintenant soap pour php est activé.
	*
	*
	* PHP version 4 et 5
	*  
	*@author	Gisio TABERA RANDRIAMANANTSOA
	*@copyright	2015	The Etamine Groupe
	*@date:		
	*/
	
	
	/*
	* Permet d'obtenir toutes les informations d'un pays sélectionner par l'utilisateur
	*
	*@param nom_du_pays
	*@return  tous les paramètres du pays
	*/
	
	mb_internal_encoding('UTF-8');
		
	/*On doit éviter la mise en cache du WSDL. Qui se fait tous les 24h
	la fonction ini_set() avec la constante prédéfinit soap.wsdl_cache_enabled
	nous permet de faire cette manipulation.
	*/
		
	ini_set('soap.wsdl_cache_enabled', 0);

	/*
	La création d'un client soap se fait par l'appel de SoapClient.
	SoapClient() prend en paramètre l'adresse de l'emplacement du fichier
	wsdl et un tableau.
	*/
		
	$service =  new SoapClient("http://localhost:8080/ws/pays.wsdl",array("trace" => 1, "exception" => 0));
		try{
			$param = new stdClass(); // Création d'un objet param


			//Cette partie permet d'avoir les informations d'un pays
			if(isset($_POST['pays'])) 									// On regarde si pays a été selectionné ou non
			{
				$pays = $_POST['pays']; 								// On affecte la valeur pris par post a une variable nommée pays
				$param -> libelle = $pays; 								// On affecte la valeur de pays à un objet appelé libellé 
				$pays = $service ->getPays($param); 					// Appel de la méthode getPays() avec comme paramètre la valeur selectionné comme libellé
				print_r( json_encode($pays -> pays)); 					// Affiche les informations du pays par rapport à la libellé choisi 
			}


			//Cette partie permet d'obtenir les listes des pays par rapport au risque
			if(isset($_GET['listePays'])) 								// On regarde si l'élément a été bien choisi
			{
				$liste_pays = $_GET['listePays']; 						// On affecte la valeur dans une variable nommée liste_pays
				if($liste_pays == "true") 								// Si la valeur de la séléction vaut true
					$param -> danger = true; 							// on affecte à l'object param de valeur danger la valeur true
				else
					$param -> danger = false;							// on affecte à l'object param de valeur danger la valeur true

				$liste_pays = $service ->getAllPaysDanger($param); 		// On fait appel à la méthode getAllPaysDanger() avec comme paramètre true/false
				$response = array(); 									// Créationn d'un tableau pour avoir la réponse
				foreach ($liste_pays->Pays as $key => $value) 			// On prend tous les pays avec le risque respectif
				{
					$response[$key] = ($value -> libelle_fr);
				}
				print_r(json_encode($response));						// Affiche la réponse de liste de pays par rapport au risque
			}
		// Dans le cas où on arrive pas a se connecter on affiche l'erreur et la comportenement du problème
		}catch(SoapFault $fault){
			echo "Error: ",$fault->faultcode,", string: ",$fault->faultstring;
		}	
   
?>