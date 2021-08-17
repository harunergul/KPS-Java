
package tr.gov.nvi.kps._2021._04._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import tr.gov.nvi.kps._2011._01._01.Parametre;


/**
 * <p>Java class for TCKKFotoBilgisi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCKKFotoBilgisi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Fotograf" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="HataBilgisi" type="{http://kps.nvi.gov.tr/2011/01/01}Parametre" minOccurs="0"/&gt;
 *         &lt;element name="TCKimlikNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCKKFotoBilgisi", propOrder = {
    "fotograf",
    "hataBilgisi",
    "tcKimlikNo"
})
public class TCKKFotoBilgisi {

    @XmlElementRef(name = "Fotograf", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> fotograf;
    @XmlElementRef(name = "HataBilgisi", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Parametre> hataBilgisi;
    @XmlElementRef(name = "TCKimlikNo", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> tcKimlikNo;

    /**
     * Gets the value of the fotograf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getFotograf() {
        return fotograf;
    }

    /**
     * Sets the value of the fotograf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setFotograf(JAXBElement<byte[]> value) {
        this.fotograf = value;
    }

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
     * Gets the value of the tcKimlikNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getTCKimlikNo() {
        return tcKimlikNo;
    }

    /**
     * Sets the value of the tcKimlikNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setTCKimlikNo(JAXBElement<Long> value) {
        this.tcKimlikNo = value;
    }

}
