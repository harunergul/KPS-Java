
package tr.gov.nvi.kps._2011._01._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for YabanciKisiDurumBilgisi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="YabanciKisiDurumBilgisi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Durum" type="{http://kps.nvi.gov.tr/2011/01/01}Parametre" minOccurs="0"/&gt;
 *         &lt;element name="MedeniHal" type="{http://kps.nvi.gov.tr/2011/01/01}Parametre" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "YabanciKisiDurumBilgisi", propOrder = {
    "durum",
    "medeniHal"
})
public class YabanciKisiDurumBilgisi {

    @XmlElementRef(name = "Durum", namespace = "http://kps.nvi.gov.tr/2011/01/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Parametre> durum;
    @XmlElementRef(name = "MedeniHal", namespace = "http://kps.nvi.gov.tr/2011/01/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Parametre> medeniHal;

    /**
     * Gets the value of the durum property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Parametre }{@code >}
     *     
     */
    public JAXBElement<Parametre> getDurum() {
        return durum;
    }

    /**
     * Sets the value of the durum property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Parametre }{@code >}
     *     
     */
    public void setDurum(JAXBElement<Parametre> value) {
        this.durum = value;
    }

    /**
     * Gets the value of the medeniHal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Parametre }{@code >}
     *     
     */
    public JAXBElement<Parametre> getMedeniHal() {
        return medeniHal;
    }

    /**
     * Sets the value of the medeniHal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Parametre }{@code >}
     *     
     */
    public void setMedeniHal(JAXBElement<Parametre> value) {
        this.medeniHal = value;
    }

}
