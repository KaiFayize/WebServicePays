//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.12.15 à 05:08:22 PM CET 
//


package io.spring.guides.gs_producing_web_service;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour pays complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="pays">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="indicatif" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nationalite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libelle_en" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libelle_fr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="monnaie_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="monnaie_perdiem" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="taux_change" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="danger" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="drapeau" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coords1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coords2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coords3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coords4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coords5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pays", propOrder = {
    "id",
    "indicatif",
    "nationalite",
    "libelleEn",
    "libelleFr",
    "monnaieCode",
    "monnaiePerdiem",
    "tauxChange",
    "danger",
    "drapeau",
    "coords1",
    "coords2",
    "coords3",
    "coords4",
    "coords5"
})
public class Pays {

    @XmlElement(name = "ID", required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected String indicatif;
    @XmlElement(required = true)
    protected String nationalite;
    @XmlElement(name = "libelle_en", required = true)
    protected String libelleEn;
    @XmlElement(name = "libelle_fr", required = true)
    protected String libelleFr;
    @XmlElement(name = "monnaie_code", required = true)
    protected String monnaieCode;
    @XmlElement(name = "monnaie_perdiem")
    protected float monnaiePerdiem;
    @XmlElement(name = "taux_change")
    protected float tauxChange;
    protected boolean danger;
    @XmlElement(required = true)
    protected String drapeau;
    @XmlElement(required = true)
    protected String coords1;
    @XmlElement(required = true)
    protected String coords2;
    @XmlElement(required = true)
    protected String coords3;
    @XmlElement(required = true)
    protected String coords4;
    @XmlElement(required = true)
    protected String coords5;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getID() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setID(BigInteger value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété indicatif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatif() {
        return indicatif;
    }

    /**
     * Définit la valeur de la propriété indicatif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatif(String value) {
        this.indicatif = value;
    }

    /**
     * Obtient la valeur de la propriété nationalite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * Définit la valeur de la propriété nationalite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalite(String value) {
        this.nationalite = value;
    }

    /**
     * Obtient la valeur de la propriété libelleEn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleEn() {
        return libelleEn;
    }

    /**
     * Définit la valeur de la propriété libelleEn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleEn(String value) {
        this.libelleEn = value;
    }

    /**
     * Obtient la valeur de la propriété libelleFr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleFr() {
        return libelleFr;
    }

    /**
     * Définit la valeur de la propriété libelleFr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleFr(String value) {
        this.libelleFr = value;
    }

    /**
     * Obtient la valeur de la propriété monnaieCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaieCode() {
        return monnaieCode;
    }

    /**
     * Définit la valeur de la propriété monnaieCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaieCode(String value) {
        this.monnaieCode = value;
    }

    /**
     * Obtient la valeur de la propriété monnaiePerdiem.
     * 
     */
    public float getMonnaiePerdiem() {
        return monnaiePerdiem;
    }

    /**
     * Définit la valeur de la propriété monnaiePerdiem.
     * 
     */
    public void setMonnaiePerdiem(float value) {
        this.monnaiePerdiem = value;
    }

    /**
     * Obtient la valeur de la propriété tauxChange.
     * 
     */
    public float getTauxChange() {
        return tauxChange;
    }

    /**
     * Définit la valeur de la propriété tauxChange.
     * 
     */
    public void setTauxChange(float value) {
        this.tauxChange = value;
    }

    /**
     * Obtient la valeur de la propriété danger.
     * 
     */
    public boolean isDanger() {
        return danger;
    }

    /**
     * Définit la valeur de la propriété danger.
     * 
     */
    public void setDanger(boolean value) {
        this.danger = value;
    }

    /**
     * Obtient la valeur de la propriété drapeau.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrapeau() {
        return drapeau;
    }

    /**
     * Définit la valeur de la propriété drapeau.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrapeau(String value) {
        this.drapeau = value;
    }

    /**
     * Obtient la valeur de la propriété coords1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoords1() {
        return coords1;
    }

    /**
     * Définit la valeur de la propriété coords1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoords1(String value) {
        this.coords1 = value;
    }

    /**
     * Obtient la valeur de la propriété coords2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoords2() {
        return coords2;
    }

    /**
     * Définit la valeur de la propriété coords2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoords2(String value) {
        this.coords2 = value;
    }

    /**
     * Obtient la valeur de la propriété coords3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoords3() {
        return coords3;
    }

    /**
     * Définit la valeur de la propriété coords3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoords3(String value) {
        this.coords3 = value;
    }

    /**
     * Obtient la valeur de la propriété coords4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoords4() {
        return coords4;
    }

    /**
     * Définit la valeur de la propriété coords4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoords4(String value) {
        this.coords4 = value;
    }

    /**
     * Obtient la valeur de la propriété coords5.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoords5() {
        return coords5;
    }

    /**
     * Définit la valeur de la propriété coords5.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoords5(String value) {
        this.coords5 = value;
    }

}
