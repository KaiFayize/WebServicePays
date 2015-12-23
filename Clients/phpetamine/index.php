<!DOCTYPE html>
<html>
<!--
	Ce fichier affichera l'index du site Etamine
	Il expliquera  c'est quoi etamine, comment utiliser Etamine,
	la page menu, pour utiliser Etamine




	@autor: Gisio TABERA RANDRIAMANANTSOA
	@version: 1.0
	@date: 28 Mars 2015
-->
<head>
	<meta charset = "utf-8"/>
	<title>Etamine c'est quoi?</title>
	<link rel="stylesheet" href="./static/css/style.css" type="text/css">
</head>
<body>
<div id="generale">
	<?php include("admin/entete.php");?>							<!-- Inclusion de l'en-tête de la page-->
	<?php include("admin/menu.php");?>								<!-- Inclusion du menu de la page-->
	<div id = "explication">
		<fieldset>
		<legend><h2> Etamine c'est quoi? </h2></legend>
		<p >Il s’agit d'un Web Service qui vous aidera à savoir un peu plus sur le pays de votre déstination.<p>
			<div id="men">
				<p>Des référentiels de pays sera accessible à distance comme: </p>
					. le libellé<br />
					. le code ISO<br />
					. la devise<br />
					. les coordonnées<br />
					. le risque<br />. la nationalité<br />
					. le nom du pays en français <br />
					. le nom du pays en anglais <br />
					. la valeur per diem<br />
					. le taux de change<br />
			</div>					
		</fieldset>
	</div>
	<?php include("admin/pied_pages.php");?>						<!-- Inclusion du pieds de la page-->
</div>
</body>
</html>