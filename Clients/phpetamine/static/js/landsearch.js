$( document ).ready(function() 
{	
	$("#land").click (function(){
		$.get( "researchland/searchland1.php", $( "#response1" ).serialize(), function( data ){
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


	$("#money_code").click (function($i){
		$.get( "researchland/searchland2.php", $( "#response2" ).serialize(), function( data ){
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

	
	$("#money_perdiem").click (function($i){
		$.get( "researchland/searchland3.php", $( "#response3" ).serialize(), function( data ){
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

	$("#exchange_value").click (function($i){
		$.get( "researchland/searchland4.php", $( "#response4" ).serialize(), function( data ){
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

	$("#risk").click (function(){
		$.get( "researchland/searchland5.php", $( "#response5" ).serialize(), function( data ){
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