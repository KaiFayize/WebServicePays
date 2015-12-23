<!DOCTYPE HTML>
<html>
<head>
	<title>Nous contacter</title>
	<link rel="stylesheet" type="text/css" href="static/css/contact.css"/>
	<?php include("admin/contenu/link_script.php");?>
</head>
<body>
<?php include("Admin/entete.php");?>
<?php include("Admin/menu.php");?>
<form id='mailform' method = "post">
	<?php include("admin/contenu/mail_formulaire/team.php");?>
	<?php include("admin/contenu/mail_formulaire/objet_message.php");?>
	<?php include("admin/contenu/mail_formulaire/utilisateur_mail.php");?>
	<?php include("admin/contenu/mail_formulaire/envoye_message.php");?>
</form>
<?php include("admin/pied_pages.php");?>
</body>	
</html>