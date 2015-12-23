<!-- Perdiem.php

    Ce fichier contient la formulaire qui permettra de
    prendre le ou les pays avec son monnei Per Diem


    @author         Gisio TABERA RANDRIAMANANTSOA
    @date           05 Avril 2015
    @version        1.0
-->

<form action="searchland3.php" method="get" id="response3" >
    <tr>
        <td><h4>Monnaie Per Diem:</h4></td><td><input type="text" id="perdiem_monnaie" name="perdiem_monnaie"/></td>
        <td>Sup <input type="radio" id ="Sup" name="monneiperdiem" value = "+"/></td>
        <td>Inf <input type="radio" id="inf" name="monneiperdiem" value = "-"/></td>
        <td>Egale<input type="radio" id="egal"name="monneiperdiem" value = "=" checked/></td>
        <td><input type="submit" id="money_perdiem"  value="Chercher" name="money_perdiem"/><br/> </td>
    </tr>
</form>