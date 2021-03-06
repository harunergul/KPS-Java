
package tr.gov.nvi.kps._2011._01._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Parametre complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Parametre"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Aciklama" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Kod" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parametre", propOrder = {
    "aciklama",
    "kod"
})
public class Parametre {

    @XmlElementRef(name = "Aciklama", namespace = "http://kps.nvi.gov.tr/2011/01/01", type = JAXBElement.class, required = false)
    protected JAXBElement<String> aciklama;
    @XmlElementRef(name = "Kod", namespace = "http://kps.nvi.gov.tr/2011/01/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> kod;

    /**
     * Gets the value of the aciklama property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAciklama() {
        return aciklama;
    }

    /**
     * Sets the value of the aciklama property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAciklama(JAXBElement<String> value) {
        this.aciklama = value;
    }

    /**
     * Gets the value of the kod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getKod() {
        return kod;
    }

    /**
     * Sets the value of the kod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setKod(JAXBElement<Integer> value) {
        this.kod = value;
    }

}
