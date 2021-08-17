
package tr.gov.nvi.kps._2021._04._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import tr.gov.nvi.kps._2011._01._01.Parametre;


/**
 * <p>Java class for BilesikKutukBilgileriSonucu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BilesikKutukBilgileriSonucu"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HataBilgisi" type="{http://kps.nvi.gov.tr/2011/01/01}Parametre" minOccurs="0"/&gt;
 *         &lt;element name="SorguSonucu" type="{http://kps.nvi.gov.tr/2021/04/01}ArrayOfBilesikKutukBilgileri" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BilesikKutukBilgileriSonucu", propOrder = {
    "hataBilgisi",
    "sorguSonucu"
})
public class BilesikKutukBilgileriSonucu {

    @XmlElementRef(name = "HataBilgisi", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Parametre> hataBilgisi;
    @XmlElementRef(name = "SorguSonucu", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfBilesikKutukBilgileri> sorguSonucu;

    /**
     * Gets the value of the hataBilgisi property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Parametre }{@code >}
     *     
     */
    public JAXBElement<Parametre> getHataBilgisi() {
        return hataBilgisi;
    }

    /**
     * Sets the value of the hataBilgisi property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Parametre }{@code >}
     *     
     */
    public void setHataBilgisi(JAXBElement<Parametre> value) {
        this.hataBilgisi = value;
    }

    /**
     * Gets the value of the sorguSonucu property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBilesikKutukBilgileri }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBilesikKutukBilgileri> getSorguSonucu() {
        return sorguSonucu;
    }

    /**
     * Sets the value of the sorguSonucu property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBilesikKutukBilgileri }{@code >}
     *     
     */
    public void setSorguSonucu(JAXBElement<ArrayOfBilesikKutukBilgileri> value) {
        this.sorguSonucu = value;
    }

}
