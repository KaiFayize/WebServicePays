$( document ).ready(function() 
{	
	$("#money_code").click (function($i){
		$.get( "searchland2.php", $( "#response2" ).serialize(), function( data ){
			var response = JSON.parse(data);
			
			 //Affiche une boite de dialogue pour permettre de voir le résultat
			$("#dialog").dialog(
	  		{
				title: "Liste des pays",
				width: 450,
				maxHeight: 350,
				modal: true,
    			hide: 'blind'
	  		});

	  		$("#response").html('');
	  		
	  		for ( var i = 0, l = response.length; i < l; i++ ) 
	  		{	 
			    
			    $("#response").append("<tr><td>"+response[i]+"</td></tr>");
			}
	  		
		});
		return false;
	})
});