
package tr.gov.nvi.kps._2021._04._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BilesikKutukSorgulaKimlikNoSorguKriteri complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BilesikKutukSorgulaKimlikNoSorguKriteri"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DogumAy" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="DogumGun" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="DogumYil" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="KimlikNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BilesikKutukSorgulaKimlikNoSorguKriteri", propOrder = {
    "dogumAy",
    "dogumGun",
    "dogumYil",
    "kimlikNo"
})
public class BilesikKutukSorgulaKimlikNoSorguKriteri {

    @XmlElementRef(name = "DogumAy", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> dogumAy;
    @XmlElementRef(name = "DogumGun", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> dogumGun;
    @XmlElementRef(name = "DogumYil", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> dogumYil;
    @XmlElementRef(name = "KimlikNo", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> kimlikNo;

    /**
     * Gets the value of the dogumAy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDogumAy() {
        return dogumAy;
    }

    /**
     * Sets the value of the dogumAy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDogumAy(JAXBElement<Integer> value) {
        this.dogumAy = value;
    }

    /**
     * Gets the value of the dogumGun property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDogumGun() {
        return dogumGun;
    }

    /**
     * Sets the value of the dogumGun property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDogumGun(JAXBElement<Integer> value) {
        this.dogumGun = value;
    }

    /**
     * Gets the value of the dogumYil property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDogumYil() {
        return dogumYil;
    }

    /**
     * Sets the value of the dogumYil property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDogumYil(JAXBElement<Integer> value) {
        this.dogumYil = value;
    }

    /**
     * Gets the value of the kimlikNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getKimlikNo() {
        return kimlikNo;
    }

    /**
     * Sets the value of the kimlikNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setKimlikNo(JAXBElement<Long> value) {
        this.kimlikNo = value;
    }

}
