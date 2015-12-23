<!--
	Ce fichier comprend les images qui illustrera les démarches à suivre si on veut utiliser
	Etamine à partir de l'index. Il montrera les étapes en affichant les images explicants 
	les marches à suivre.

	


	Date 18 mars 2015
	Author Gisio TABERA RANDRIAMANANTSOA
	Version 1.0
-->


<!DOCTYPE html>
<html>
<head>
	<meta charset = "utf-8"/>
	<title>Comment utiliser Etamine</title>
	<link rel="stylesheet" href="static/css/style.css" type="text/css">
</head>
<body>
	<?php require_once("admin/entete.php");?>
	<?php require_once("admin/menu.php");?>
	<div id="utilisation">
		<br /><br />
		<h2> Comment utiliser Etamine? </h2><br/><br />
		<p>1. Cliquez sur <strong>"PRODUCTS" </strong>-> Allez dans <strong>Utiliser Etamine </strong></p><br />
		<img src="static/img/Etape11.png"/><br/><br />
		<p>2. Vous allez trouvez une page identique à celui de la figure ci-dessous. <br/> <br /> 
			Il suffit maintenant de choisir les informations dont vous avez besoin.
			Comme: l"indicatif du pays, le coordonnées, Code Iso,.. Mais aussi le taux d'echange, le nom du pays en français ou/et en anglais, la nationalité. 
			Et aussi si le pays est <strong>à risque ou pas.</strong></p> <br />
		<img src="static/img/Etape12.png"/><br/><br />
		<p>3. Maintenant vous cliquez sur <strong>"Chercher"</strong>et voila, vous obtenez vos informations du pays.</p> <br />
		<img src ="static/img/Etape13.png"/><br/><br />
		<p>4. Voici un exemple du résultat de la recheche:</p><br/>
		<img src ="static/img/etamine_reponse.png"/><br/>
		<p>Pour fermer l'onglet, il suffit de cliquer sur "Entrée" du clavier ou bien cliquer sur la croix de l'onglet qui s'affiche</p>
		<img src ="static/img/etamine_recherche1.png"/><br/>
		<p><strong>Etamine permet aussi de lister tous les pays par rapport au risque.</strong></p><br />
		<p>Il suffit de choisir la situation des riques de votre choix, dans la partie où il y a écrit "Pour afficher tous les Pays" puis cliquer sur "Afficher"</p><br />
		C'est à dire <strong>Etape a</strong> puis <strong>Etape b</strong> <br/>
		<img src="static/img/etamine_listePays.png"/><br/>
		<p>Example de resultat fourni:</p>
		<img src="static/img/etamine_recherche2.png"><br/>
		<p>Si on veut avoir plus d'informations, il suffit de cliquer sur <strong>"Cliquer ici pour avoir plus de détail sur une recherche"</strong>, la page suivante souvrira:</p>
		<img src="static/img/Etape14.png"><br/>
		<p>Ici, le résultat de la recherche sera affichée par rapport au caractère insérer: </p> Exemple d'une recherche sur les pays
		ayant un <strong>"M"</strong> comme commencement de leur code monnaie.<br/>
		<img src="static/img/etamine_recherche3.png"><br/>
		<h3 align="center">Amusez vous maintenant à utiliser Etamine</h3>
	</div>
	<?php include("admin/pied_pages.php");?>
</body>
</html>