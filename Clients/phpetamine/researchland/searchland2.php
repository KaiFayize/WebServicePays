<?php
	
	mb_internal_encoding('UTF-8');	
	
	ini_set('soap.wsdl_cache_enabled', 0);		
	$service =  new SoapClient("http://localhost:8080/ws/pays.wsdl",array("trace" => 1, "exception" => 0));
		try{
			$param = new stdClass(); 
			if(isset($_GET['monnaie_code'])) 									// On regarde si pays a été selectionné ou non
			{
				$codemonnaie = $_GET['monnaie_code'];
				$param -> monnaie_code = $codemonnaie;
				$pays = $service -> getListPays($param);
				$response = array();
				$listpays = $pays -> Pays;
				if(sizeof($pays -> Pays) == 1)
				{
					/**
					 *[{'libelle': 'libelle_test', 'code_monney': 'CD_MONEY'}]
					 */
					$response= array($listpays -> libelle_fr , $listpays -> monnaie_code);
					print_r(json_encode($response));
				}
				else{
					/**
					 *[{'libelle': 'libelle_test', 'code_monney': 'CD_MONEY'},
					 * {'libelle': 'libelle_test2', 'code_monney': 'OTHER_CD_MONEY'}]
					 */
					foreach ($listpays as $key => $value)
					{
						$response[$key] = array($value -> libelle_fr, 
						$value -> monnaie_code);
					}
					print_r(json_encode($response));
				}
			}
		}catch(SoapFault $fault){
			echo "Error: ",$fault -> faultcode,", string: ",$fault->faultstring;
		}	  
?>
