<?php
	
	mb_internal_encoding('UTF-8');	
	
	ini_set('soap.wsdl_cache_enabled', 0);		
	$service =  new SoapClient("http://localhost:8080/ws/pays.wsdl",array("trace" => 1, "exception" => 0));
		try{
			
			$param = new stdClass(); 
			if(isset($_GET['perdiem_monnaie'])) 									// On regarde si pays a été selectionné ou non
			{
				$perdiem = $_GET['perdiem_monnaie'];
				$param -> monnaie_perdiem = $perdiem; 
				if(isset($_GET['monneiperdiem']))
				{	
					//$params = new stdClass();
					$arg = $_GET['monneiperdiem'];
					if($arg == '+'){
						$val = '+';
						$param -> monnaie_perdiem_arg = $val;						
					}

					if($arg == '-'){
						$val = '-';
						$param -> monnaie_perdiem_arg = $val; 								
					}

					if($arg == '='){
						$val = $perdiem;
						$param -> monnaie_perdiem_arg = $val;	
					}
				}

				$perdiem = $service -> getListPays($param);
				$tab = $perdiem -> Pays;
				$response = array();
				foreach ($tab as $key => $value) 
				{
					$response[$key] = array($value -> libelle_fr, 
						$value -> monnaie_perdiem);
				}
				print_r( json_encode($response));  					// Affiche les informations du pays par rapport à la libellé choisi 
			}
		}catch(SoapFault $fault){
			echo "Error: ",$fault->faultcode,", string: ",$fault->faultstring;
		}	  
?>
