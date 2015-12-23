<?php

	
	mb_internal_encoding('UTF-8');	
	ini_set('soap.wsdl_cache_enabled', 0);
		
	$service =  new SoapClient("http://localhost:8080/ws/pays.wsdl",array("trace" => 1, "exception" => 0));
		try{
			$param = new stdClass();

			if(isset($_GET['risque'])) 								// On regarde si l'élément a été bien choisi
			{
				$liste_pays = $_GET['risque']; 						// On affecte la valeur dans une variable nommée liste_pays
				if($liste_pays == "true") 								// Si la valeur de la séléction vaut true
					$param -> danger = true; 							// on affecte à l'object param de valeur danger la valeur true
				else
					$param -> danger = false;															// on affecte à l'object param de valeur danger la valeur true

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