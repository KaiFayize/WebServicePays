//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.12.15 à 05:08:22 PM CET 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="indicatif" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="monnaie_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="monnaie_perdiem" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="monnaie_perdiem_arg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taux_change" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="taux_change_arg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="danger" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "indicatif",
    "libelle",
    "monnaieCode",
    "monnaiePerdiem",
    "monnaiePerdiemArg",
    "tauxChange",
    "tauxChangeArg",
    "danger"
})
@XmlRootElement(name = "getListPaysRequest")
public class GetListPaysRequest {

    @XmlElement(required = true, nillable = true)
    protected String indicatif;
    @XmlElement(required = true, nillable = true)
    protected String libelle;
    @XmlElement(name = "monnaie_code", required = true, nillable = true)
    protected String monnaieCode;
    @XmlElement(name = "monnaie_perdiem", required = true, type = Float.class, nillable = true)
    protected Float monnaiePerdiem;
    @XmlElement(name = "monnaie_perdiem_arg", required = true, nillable = true)
    protected String monnaiePerdiemArg;
    @XmlElement(name = "taux_change", required = true, type = Float.class, nillable = true)
    protected Float tauxChange;
    @XmlElement(name = "taux_change_arg", required = true, nillable = true)
    protected String tauxChangeArg;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean danger;

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
     * Obtient la valeur de la propriété libelle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Définit la valeur de la propriété libelle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelle(String value) {
        this.libelle = value;
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
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMonnaiePerdiem() {
        return monnaiePerdiem;
    }

    /**
     * Définit la valeur de la propriété monnaiePerdiem.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMonnaiePerdiem(Float value) {
        this.monnaiePerdiem = value;
    }

    /**
     * Obtient la valeur de la propriété monnaiePerdiemArg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonnaiePerdiemArg() {
        return monnaiePerdiemArg;
    }

    /**
     * Définit la valeur de la propriété monnaiePerdiemArg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonnaiePerdiemArg(String value) {
        this.monnaiePerdiemArg = value;
    }

    /**
     * Obtient la valeur de la propriété tauxChange.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTauxChange() {
        return tauxChange;
    }

    /**
     * Définit la valeur de la propriété tauxChange.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTauxChange(Float value) {
        this.tauxChange = value;
    }

    /**
     * Obtient la valeur de la propriété tauxChangeArg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTauxChangeArg() {
        return tauxChangeArg;
    }

    /**
     * Définit la valeur de la propriété tauxChangeArg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTauxChangeArg(String value) {
        this.tauxChangeArg = value;
    }

    /**
     * Obtient la valeur de la propriété danger.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDanger() {
        return danger;
    }

    /**
     * Définit la valeur de la propriété danger.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDanger(Boolean value) {
        this.danger = value;
    }

}
