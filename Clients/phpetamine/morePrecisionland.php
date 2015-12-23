<html>
<head>
  <title>Recherche affiner</title>
  <meta charset="UTF-8">
  <?php include("admin/contenu/link_script.php");?> 
</head>
<body>
<?php include("admin/entete.php");?>                                <!-- Inclusion de l'en-tête de la page-->
<?php include("admin/menu.php");?>                                  <!-- Inclusion du menu de la page-->
<div id="precis" align="center">
  
    <fieldset>
      <legend><h3>Recherche d'informations</h3></legend>
      <table> 
        <?php include("admin/contenu/PHPSearch/Pays.php");?>
        <?php include("admin/contenu/PHPSearch/Codemonnaie.php");?>
        <?php include("admin/contenu/PHPSearch/Perdiem.php");?>
        <?php include("admin/contenu/PHPSearch/Tauxchange.php");?> 
        <?php include("admin/contenu/PHPSearch/Risque.php");?>     
    </table>
  </fieldset>
<p><h4>Pour revenir à la page d'Etamine cliquez</h4> <a href = 'menus.php'><input type="submit" id="ici"  value="ici" name="ici"/></a></p>
</div>
<div id="dialog" title="Basic dialog" hidden>
  <section id="response"><table ><th>LIBELLE</th><tr id='appendhere1' width="100%"></tr></table></section>
</div>

<?php include("admin/pied_pages.php");?>
</body>
</html>