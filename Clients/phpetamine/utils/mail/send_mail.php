<?php
include("Mail.php");
$errLevel = error_reporting(E_ALL & ~E_NOTICE & ~E_STRICT & ~E_DEPRECATED);
	/********************************************************************************************
										CONFIGURATION
	*********************************************************************************************/

	// Action du formulaire (si votre page a des paramètres dans l'URL)
	// si cette page est index.php?page=contact alors mettez index.php?page=contact
	// Messages de confirmation du mail
	$message_envoye = "Votre message nous est bien parvenu !";
	$message_non_envoye = "L'envoi du mail a echoue, veuillez reessayer SVP.";
 
	// Message d'erreur du formulaire
	$message_formulaire_invalide = "Verifiez que tous les champs soient bien remplis et que l'email soit sans erreur.";
 
	/*********************************************************************************************
										FIN DE LA CONFIGURATION
	*********************************************************************************************/
 
/*
 * cette fonction sert à nettoyer et enregistrer un texte
 */
function rec($text)
	{
		$text = htmlspecialchars(trim($text), ENT_QUOTES);
		if (1 === get_magic_quotes_gpc())
		{
			$text = stripslashes($text);
		}
 
		$text = nl2br($text);
		return $text;
	}
/*
 * Cette fonction sert à vérifier la syntaxe d'un email
 */
 
function isEmail($email)
{
	$value = preg_match('/^(?:[\w\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+\.)*[\w\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+@(?:(?:(?:[a-zA-Z0-9_](?:[a-zA-Z0-9_\-](?!\.)){0,61}[a-zA-Z0-9_-]?\.)+[a-zA-Z0-9_](?:[a-zA-Z0-9_\-](?!$)){0,61}[a-zA-Z0-9_]?)|(?:\[(?:(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])\]))$/', $email);
	return (($value === 0) || ($value === false)) ? false : true;
}
 

function send_mail($nom, $from, $to, $subject, $body){
	$headers = array(
		'From' => $nom.'<'.$from.'>',
		'To' => $to,
		'Subject' => $subject
	);

	$smtp = Mail::factory('smtp', array(
			'host' => 'ssl://smtp.gmail.com',
			'port' => '465',
			'auth' => true,
			'username' => 'gisio.tabera@gmail.com',
			'password' => 'campusfrance'
		));

	$mail = $smtp->send($to, $headers, $body);

	if (PEAR::isError($mail)) {
		return false;
	} else {
		return true;
	}
}

// formulaire envoyé, on récupère tous les champs.
$nom     = (isset($_POST['nom']))     ? rec($_POST['nom'])     : '';
$email   = (isset($_POST['email']))   ? rec($_POST['email'])   : '';
$objet   = (isset($_POST['objet']))   ? rec($_POST['objet'])   : '';
$message = (isset($_POST['message'])) ? rec($_POST['message']) : '';
 
// On va vérifier les variables et l'email ...
$email = (isEmail($email)) ? $email : ''; // soit l'email est vide si erroné, soit il vaut l'email entré
$err_formulaire = false; // sert pour remplir le formulaire en cas d'erreur si besoin


	if(isset($_POST['choix_personne']))
	{
		switch ($_POST['choix_personne']) 
		{
			case 'fortier':
				$destination = "fortier@lipn.univ-paris13.fr";
				break;
			case 'damien':
				$destination ='damien.larmine@gmail.com';
				break;
			case 'quentin':
				$destination ='quentin.amelot@hotmail.fr';
				break;
			/*case 'paul':
				/$destination ='pjbaud@hotmail';
			break;*/
			case 'jeremie':
				$destination ='jeremie.nizou@gmail.fr';
			break;
			case 'kaimou':
				$destination ='kai.fayize@gmail.com';
			break;
			case 'gisio':
				$destination='gisio.tabera@gmail.com';
			break;
		}
	} 
	if (($nom != '') && ($email != '') && ($objet != '') && ($message != ''))
	{
		// Remplacement de certains caractères spéciaux
		$message = str_replace("&#039;","'",$message);
		$message = str_replace("&#8217;","'",$message);
		$message = str_replace("&quot;",'"',$message);
		$message = str_replace('&lt;br&gt;','',$message);
		$message = str_replace('&lt;br /&gt;','',$message);
		$message = str_replace("&lt;","&lt;",$message);
		$message = str_replace("&gt;","&gt;",$message);
		$message = str_replace("&amp;","&",$message);
 
		// Envoi du mail
		if (send_mail($nom, $email, $destination, $objet, $message) == true){
			echo "$message_envoye";
		}else{
			echo "$message_non_envoye";
		}
	}else{
		// une des 3 variables (ou plus) est vide ...
		echo "Verifiez que tous les champs soient bien remplis et que l email soit sans erreur.";
		$err_formulaire = true;
	};