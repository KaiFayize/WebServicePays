<!-- 
@author Gisio TABERA RANDRIAMANANTSOA
@date 18 Mars 2015

ICI  se trouve les boutons pour afficher la liste des pays par rapport au risque 
-->

<div id="pays_risque_liste"> 
 	<form action="clientSoap.php" id="affier_danger" methode="get">
 		<fieldset id="liste_pays_risque">
 			<legend><h3>Pour afficher tous les Pays</h3></legend>
			<input type="radio" name="listePays" value="true" checked/>Avec risque
			<input type="radio" name="listePays" value="false" />Sans risque
			<input type="submit" id="afficher_risque"  value="afficher" name="Afficher"/><br/>
		</fieldset>
	 </form>
</div>