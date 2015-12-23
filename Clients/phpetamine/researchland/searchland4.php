<?php
	
	mb_internal_encoding('UTF-8');	
	
	ini_set('soap.wsdl_cache_enabled', 0);		
	$service =  new SoapClient("http://localhost:8080/ws/pays.wsdl",array("trace" => 1, "exception" => 0));
		try{
			
			$param = new stdClass(); 
			if(isset($_GET['tauxdechange'])) 									// On regarde si pays a été selectionné ou non
			{
				$change = $_GET['tauxdechange'];
				$param -> taux_change = $change; 
				if(isset($_GET['taux_change']))
				{	
					//$params = new stdClass();
					$arg = $_GET['taux_change'];
					if($arg == '+'){
						$val = '+';
						$param -> taux_change_arg = $val;						
					}

					if($arg == '-'){
						$val = '-';
						$param -> taux_change_arg = $val; 								
					}

					if($arg == '='){
						$val = $change;
						$param -> taux_change_arg = $val;	
					}
				}

				$change = $service -> getListPays($param);
				$tab = $change -> Pays;
				$response = array();
				foreach ($tab as $key => $value) 
				{
					if($value -> libelle_fr == true){
					$response[$key] = array($value -> libelle_fr, 
						$value -> taux_change);
					}
				}
				print_r( json_encode($response));  					// Affiche les informations du pays par rapport à la libellé choisi 
			}
		}catch(SoapFault $fault){
			echo "Error: ",$fault->faultcode,", string: ",$fault->faultstring;
		}	  
?>
