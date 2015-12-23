<!-- Pays.php

	Ce fichier contient la formulaire qui permettra de
	prendre le ou les pays de la recherche


	@author			Gisio TABERA RANDRIAMANANTSOA
	@date			05 Avril 2015
	@version		1.0
-->


<form action="searchland1.php" method="get" id="response1" >
    <tr>
        <td><h4>Rechercher un pays</h4></td>
        <td><input type="text" id="libelle" name="libelle"/></td>
        <td>Nom en français <input type="radio" id ="libelle_fr" name="lang" value = "libelle_fr" checked/></td>
        <td>Nom en anglais <input type="radio" id="libelle_en" name="lang" value = "libelle_en"/></td>
        <td></td>
        <td><input type="submit" id="land"  value="Chercher"/></td>
    </tr>
</form>