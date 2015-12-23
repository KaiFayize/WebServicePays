/*
* Date: 25 Mars 2015
* 
* Permet d'afficher les réponses par le client PHP Soap
* Ici on affichera la réponse dans un tableau 
* La réponse dépendera des paramètres choisis par l'utilisateur
* En utilisant ().ready() nous permet de rester sur une seule page 
*
*
*
*Autor Gisio TABERA RANDRIAMANANTSOA
*Version 1.0
*/
$( document ).ready(function() 
{
	/*
	* Renvoie les informations concernant un pays sélectionné 
	* @param  dépend du  choix (id, libellé, indicatif, ...)
	* @return information concernant le pays dépendant du choix
	*/
    $("#rechercher").click (function() 
    {
 
        $.post( "clientSoap.php", $( "#test" ).serialize(), function( data ) 
        {
				//Affiche une boite de dialogue pour permettre de voir le résultat
		  		$("#dialog").dialog(
		  		{
					title: "Resultat de la recherche",
					width: 500,
					maxHeight: 350,
					modal: true,
    				hide: 'blind'
		  		});
		  		
		  		var response = JSON.parse(data);
		  		$("#response").html('');
		  		
		  		tab = $("input[type=checkbox]:checked");
		  		if ( tab.size() == 0 )
		 		{
			  		/*
			  		*Dans le cas où on ne selectionne aucune case à cocher, on affichera tous
			  		*les éléments du pays qui est dans la sélection
			  		*
			  		*@return tout les valeurs du tableaux.
			  		*/
			  		tab_v = $("input[type=checkbox]");
					tab_v.each(function(index)
					{

					 	 	if (tab_v[index].name != 'drapeau')
					 	 	{  
			
								$("#response").append("<tr><td>"+tab_v[index].name+"</td><td>"+response[tab_v[index].id]+"</td></tr>");
					  		}else
					  		{
								$("#response").append("<tr><td>"+tab_v[index].name+"</td><td><img src='"+response[tab_v[index].id]+"' /></td></tr>");
					  		}

			  		});
			  			/*
			 			 * Dans le cas où on fait un choix, renvoie la liste des choix concernant le pays 
			 			 *	@return parametre cocher
			  			*/
		 		}else{
		 		 	tab.each(function(index)
		 		 	{

						if (tab[index].name != 'drapeau')  
							{  
								$("#response").append("<tr><td>"+tab[index].name+"</td><td>"+response[tab[index].id]+"</td></tr>");
					  		}else{
								$("#response").append("<tr><td>"+tab[index].name+"</td><td><img src='"+response[tab[index].id]+"' /></td></tr>");
					  		}

		  			});
				}
			});
		return false;
   	});
/*
*Cette fonction permet d'afficher la liste de tous les pays par rapport au rique
*@param risque qui est une valeur booléenne
*@return liste de pays 
*/
	$("input#afficher_risque").click(function(){
		$.get( "clientSoap.php", $( "#affier_danger" ).serialize(), function( data ){
			var response = JSON.parse(data);
			
			 //Affiche une boite de dialogue pour permettre de voir le résultat
			$("#dialog").dialog(
	  		{
				title: "Liste des pays",
				width: 450,
				maxHeight: 350,
				modal: true,
    			hide: 'blind',
	  		});
	  		$("#response").html('');
	  		for ( var i = 0, l = response.length; i < l; i++ ) {	// Ob fait une boucle pour qu'on puisse afficher tous les éléments du tableau "response" 
			    
			    $("#response").append("<tr><td>"+response[i]+"</td></tr>");
			}
	  		
		});
		
  			
		return false;
	})

});