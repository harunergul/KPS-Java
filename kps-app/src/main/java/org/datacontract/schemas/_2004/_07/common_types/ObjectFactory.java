
package org.datacontract.schemas._2004._07.common_types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.common_types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfCstBilesikKutukServisDoluBilesen_QNAME = new QName("http://schemas.datacontract.org/2004/07/Common.Types.Constants", "ArrayOfCstBilesikKutukServisDoluBilesen");
    private final static QName _CstBilesikKutukServisDoluBilesen_QNAME = new QName("http://schemas.datacontract.org/2004/07/Common.Types.Constants", "CstBilesikKutukServisDoluBilesen");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.common_types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfCstBilesikKutukServisDoluBilesen }
     * 
     */
    public ArrayOfCstBilesikKutukServisDoluBilesen createArrayOfCstBilesikKutukServisDoluBilesen() {
        return new ArrayOfCstBilesikKutukServisDoluBilesen();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCstBilesikKutukServisDoluBilesen }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfCstBilesikKutukServisDoluBilesen }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Common.Types.Constants", name = "ArrayOfCstBilesikKutukServisDoluBilesen")
    public JAXBElement<ArrayOfCstBilesikKutukServisDoluBilesen> createArrayOfCstBilesikKutukServisDoluBilesen(ArrayOfCstBilesikKutukServisDoluBilesen value) {
        return new JAXBElement<ArrayOfCstBilesikKutukServisDoluBilesen>(_ArrayOfCstBilesikKutukServisDoluBilesen_QNAME, ArrayOfCstBilesikKutukServisDoluBilesen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CstBilesikKutukServisDoluBilesen }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CstBilesikKutukServisDoluBilesen }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Common.Types.Constants", name = "CstBilesikKutukServisDoluBilesen")
    public JAXBElement<CstBilesikKutukServisDoluBilesen> createCstBilesikKutukServisDoluBilesen(CstBilesikKutukServisDoluBilesen value) {
        return new JAXBElement<CstBilesikKutukServisDoluBilesen>(_CstBilesikKutukServisDoluBilesen_QNAME, CstBilesikKutukServisDoluBilesen.class, null, value);
    }

}
