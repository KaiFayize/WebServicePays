	/*
	* 
	*Ce fichier javascript verifiera les bons syntaxe pour permettre l'envoie d'un message
	*Il s'enclanchera lorsque l'utilisateur cliquera sur Envoyer.
	*Il va faire appel au fichier send_mail.php où celui-ci verifier si les conditions 
	*de l'envoie du message soit valide
	*
	*
	*@return Resultat l'état de l'envoie du message 
	*Date: 28 Mars 2015 
	*@autor Gisio TABERA RANDRIAMANANTSOA
	*@version 1.0
	*/
$( document ).ready(function() {
	/**
	* Renvoie une requete pour effectuer la recherche après avoir cliquer de Go
	* @param sendmail
	*/
    $( "#sendmail" ).click(function() {
 
        $.post( "utils/mail/send_mail.php", $( "#mailform" ).serialize(), function( data ) {
		alert(data);
		})
		return false;
    });
 
});