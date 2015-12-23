<!-- Tauxchange.php

    Ce fichier contient la formulaire qui permettra de
    prendre le ou les pays avec son Taux de change


    @author         Gisio TABERA RANDRIAMANANTSOA
    @date           05 Avril 2015
    @version        1.0
-->

<form action="searchland4.php" method="get" id="response4" >
    <tr>
        <td><h4>Taux de change:</h4></td>
        <td><input type="text" name="tauxdechange"value=""/></td>
        <td>Sup <input type="radio" name="taux_change" value="+"/></td>
        <td>Inf <input type="radio" name="taux_change" value="-"/></td>
        <td>Egale<input type="radio" name="taux_change" value="=" checked/></td>
        <td><input type="submit" id="exchange_value"  value="Chercher" name="exchange_value"/><br/> </td>
    </tr>
</form>