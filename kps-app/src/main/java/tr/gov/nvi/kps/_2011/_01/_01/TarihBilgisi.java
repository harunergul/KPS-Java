
package tr.gov.nvi.kps._2011._01._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TarihBilgisi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TarihBilgisi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Gun" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Yil" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TarihBilgisi", propOrder = {
    "ay",
    "gun",
    "yil"
})
public class TarihBilgisi {

    @XmlElementRef(name = "Ay", namespace = "http://kps.nvi.gov.tr/2011/01/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> ay;
    @XmlElementRef(name = "Gun", namespace = "http://kps.nvi.gov.tr/2011/01/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> gun;
    @XmlElementRef(name = "Yil", namespace = "http://kps.nvi.gov.tr/2011/01/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> yil;

    /**
     * Gets the value of the ay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getAy() {
        return ay;
    }

    /**
     * Sets the value of the ay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setAy(JAXBElement<Integer> value) {
        this.ay = value;
    }

    /**
     * Gets the value of the gun property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getGun() {
        return gun;
    }

    /**
     * Sets the value of the gun property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setGun(JAXBElement<Integer> value) {
        this.gun = value;
    }

    /**
     * Gets the value of the yil property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getYil() {
        return yil;
    }

    /**
     * Sets the value of the yil property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setYil(JAXBElement<Integer> value) {
        this.yil = value;
    }

}
