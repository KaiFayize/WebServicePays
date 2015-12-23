<!DOCTYPE html>
<html>
<!--
	Ce fichier affichera la page pour utiliser étamine

	@author  Gisio TABERA RANDRIAMANANTSOA
	@date Mars 2015
	@version 1.0
-->

<head>
	<title>Menu</title>
	<meta charset="UTF-8">
</head>
<body>
<?php include("admin/contenu/link_script.php");?>
<?php include("admin/entete.php");?>																<!-- Inclusion de l'en-tête de la page-->
<?php include("admin/menu.php");?>																	<!-- Inclusion du menu de la page-->
<div id="choix" align="center">
<section> 
	 <aside>
	 	<div class="choix">
	 		<form action="clientSoap.php" id="test" methode="post">
				<fieldset>
					<legend><h3>Selectionnez votre choix</h3></legend>
	 				<table>
	 					<?php include("admin/contenu/menu_formulaire/liste_choix.php");?>			<!-- Inclusion de la liste des choix à chercher-->
	 				</table>Choix du pays: 
					<select name="pays" id="pays">
			        	<?php include("admin/world/world.php");?>									<!-- Inclusion de la liste des pays à chercher-->
			    	</select>
					<input type="submit" id="rechercher"  value="Chercher" name="ok"/><br/>					
				</fieldset>
	 		</form>
	 	</div>
	</aside>
	<p><a href = 'morePrecisionland.php'><input type="submit" id="ici"  value="Cliquer ici pour être redirigé sur une autre page de recherche " name="ici"/></a></p>
</section>
</div>
<?php include("admin/contenu/menu_formulaire/bouton_risque_pays.php");?>							<!-- Inclusion du bouton pour la recherche de la risque-->
<div id="dialog" title="Basic dialog" hidden>
	<section id="response"><table width="100%"><th>Libellé</th><th>Valeur</th><tr id='appendhere' width="100%"></tr></table></section>
</div>
 
<div id="dialog_liste_pays" title="Basic dialog1" hidden>
	<section id="liste_pays"><table><th>LIBELLE</th><tr id='appendhere1' width="100%"></tr></table></section>
</div>

<?php include("admin/pied_pages.php");?>															<!-- Inclusion du pieds de la page-->
</body>
</html>