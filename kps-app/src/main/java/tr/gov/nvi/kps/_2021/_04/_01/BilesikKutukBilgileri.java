
package tr.gov.nvi.kps._2021._04._01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.common_types.ArrayOfCstBilesikKutukServisDoluBilesen;
import tr.gov.nvi.kps._2011._01._01.Parametre;


/**
 * <p>Java class for BilesikKutukBilgileri complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BilesikKutukBilgileri"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DoluBilesenler" type="{http://schemas.datacontract.org/2004/07/Common.Types.Constants}ArrayOfCstBilesikKutukServisDoluBilesen" minOccurs="0"/&gt;
 *         &lt;element name="HataBilgisi" type="{http://kps.nvi.gov.tr/2011/01/01}Parametre" minOccurs="0"/&gt;
 *         &lt;element name="KimlikNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="MaviKartliKisiKutukleri" type="{http://kps.nvi.gov.tr/2021/04/01}MaviKartKisiKutukleri" minOccurs="0"/&gt;
 *         &lt;element name="TCVatandasiKisiKutukleri" type="{http://kps.nvi.gov.tr/2021/04/01}TCVatandasiKisiKutukleri" minOccurs="0"/&gt;
 *         &lt;element name="YabanciKisiKutukleri" type="{http://kps.nvi.gov.tr/2021/04/01}YabanciKisiKutukleri" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BilesikKutukBilgileri", propOrder = {
    "doluBilesenler",
    "hataBilgisi",
    "kimlikNo",
    "maviKartliKisiKutukleri",
    "tcVatandasiKisiKutukleri",
    "yabanciKisiKutukleri"
})
public class BilesikKutukBilgileri {

    @XmlElementRef(name = "DoluBilesenler", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCstBilesikKutukServisDoluBilesen> doluBilesenler;
    @XmlElementRef(name = "HataBilgisi", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Parametre> hataBilgisi;
    @XmlElementRef(name = "KimlikNo", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> kimlikNo;
    @XmlElementRef(name = "MaviKartliKisiKutukleri", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<MaviKartKisiKutukleri> maviKartliKisiKutukleri;
    @XmlElementRef(name = "TCVatandasiKisiKutukleri", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<TCVatandasiKisiKutukleri> tcVatandasiKisiKutukleri;
    @XmlElementRef(name = "YabanciKisiKutukleri", namespace = "http://kps.nvi.gov.tr/2021/04/01", type = JAXBElement.class, required = false)
    protected JAXBElement<YabanciKisiKutukleri> yabanciKisiKutukleri;

    /**
     * Gets the value of the doluBilesenler property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCstBilesikKutukServisDoluBilesen }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCstBilesikKutukServisDoluBilesen> getDoluBilesenler() {
        return doluBilesenler;
    }

    /**
     * Sets the value of the doluBilesenler property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCstBilesikKutukServisDoluBilesen }{@code >}
     *     
     */
    public void setDoluBilesenler(JAXBElement<ArrayOfCstBilesikKutukServisDoluBilesen> value) {
        this.doluBilesenler = value;
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

    /**
     * Gets the value of the maviKartliKisiKutukleri property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MaviKartKisiKutukleri }{@code >}
     *     
     */
    public JAXBElement<MaviKartKisiKutukleri> getMaviKartliKisiKutukleri() {
        return maviKartliKisiKutukleri;
    }

    /**
     * Sets the value of the maviKartliKisiKutukleri property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MaviKartKisiKutukleri }{@code >}
     *     
     */
    public void setMaviKartliKisiKutukleri(JAXBElement<MaviKartKisiKutukleri> value) {
        this.maviKartliKisiKutukleri = value;
    }

    /**
     * Gets the value of the tcVatandasiKisiKutukleri property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TCVatandasiKisiKutukleri }{@code >}
     *     
     */
    public JAXBElement<TCVatandasiKisiKutukleri> getTCVatandasiKisiKutukleri() {
        return tcVatandasiKisiKutukleri;
    }

    /**
     * Sets the value of the tcVatandasiKisiKutukleri property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TCVatandasiKisiKutukleri }{@code >}
     *     
     */
    public void setTCVatandasiKisiKutukleri(JAXBElement<TCVatandasiKisiKutukleri> value) {
        this.tcVatandasiKisiKutukleri = value;
    }

    /**
     * Gets the value of the yabanciKisiKutukleri property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link YabanciKisiKutukleri }{@code >}
     *     
     */
    public JAXBElement<YabanciKisiKutukleri> getYabanciKisiKutukleri() {
        return yabanciKisiKutukleri;
    }

    /**
     * Sets the value of the yabanciKisiKutukleri property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link YabanciKisiKutukleri }{@code >}
     *     
     */
    public void setYabanciKisiKutukleri(JAXBElement<YabanciKisiKutukleri> value) {
        this.yabanciKisiKutukleri = value;
    }

}
