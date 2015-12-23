<!--
	Ce fichier contient la liste des choix possibles du web service.
	Il prend en compte l'ID, indicatif, libelle en français et en anglais, la nationalité,
	taux de change, le monnaie per diem et enfin le code monnaie


	@author Gisio TABERA RANDRIAMANANTSOA
	@version 1.0
	@date 28 Mars 2015
-->

<tr>
	<td><input type="checkbox" id="ID" name="ID"/><label> ID </label></td>
	<td><input type="checkbox" id="indicatif" name="Indicatif"/><label> Indicatif </label></td>
	<td><input type="checkbox" id="libelle_fr" name="Nom du pays en français"/><label> Nom du pays en Français </label></td>
	<td><input type="checkbox" id="libelle_en" name="Nom du pays en anglais"/><label> Nom du pays en Anglais </label></td>
	<td><input type="checkbox" id="nationalite" name="Nationalité" /><label> Nationalité </label></td>
</tr>
<tr>
	<td><input type="checkbox" id="taux_change" name="Taux De change"/><label> Taux de change </label></td>
	<td><input type="checkbox" id="monnaie_code" name="Code monnaie"/><label> Code Monnaie </label></td>
	<td><input type="checkbox" id="monnaie_perdiem" name="Monnaie Peridiem"/><label> Monnaie Per Diem </label></td>
	<td><label>Risque</label><br />
	<input type="checkbox" id="danger" name="Risque"/><label>Afficher le risque du pays</label><br />
	</td>
</tr>
<tr>
	<td>
		<input type="checkbox" id="drapeau" name="drapeau"/>Drapeau
	</td>
</tr>