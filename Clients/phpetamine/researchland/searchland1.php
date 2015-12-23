<?php
	
	mb_internal_encoding('UTF-8');	

	ini_set('soap.wsdl_cache_enabled', 0);		
	$service =  new SoapClient("http://localhost:8080/ws/pays.wsdl",array("trace" => 1, "exception" => 0));
		try
		{
			$param = new stdClass(); 	
			if(isset($_GET['libelle'])) 									
			{
				$pays = $_GET['libelle'];
				$param -> libelle = $pays;
				if(isset($_GET['lang']))
				{
					$arg = $_GET['lang'];
					if($arg == 'libelle_fr')
					{
						$pays = $service -> getListPays($param);
						$libelle =  $pays -> Pays;
						if(sizeof($libelle) == 1)
						{
							print_r('["'.$libelle -> libelle_fr.'"]');
							return true;
						}else
						{
							$response = array();
							foreach ($libelle as $key => $value) 
							{
								$response[$key]= ($value -> libelle_fr);	
							}
							print_r(json_encode($response));
						}
					}
					if($arg == 'libelle_en')
					{
						$arg = $_GET['lang'];
						if($arg == 'libelle_en')
						{
							$pays = $service -> getListPays($param);
							$libelle =  $pays -> Pays;
							if(sizeof($libelle) == 1)
							{
								print_r('["'.$libelle -> libelle_en.'"]');
								return true;
							}else
							{
								$response = array();
								foreach ($libelle as $key => $value) 
								{
									$response[$key]= ($value -> libelle_en);	
								}
								print_r(json_encode($response));
							}
						}
					}
				}
			}
		}catch(SoapFault $fault){
			echo "Error: ",$fault->faultcode,", string: ",$fault->faultstring;
		}	  
?>
