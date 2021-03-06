package tr.gov.nvi.kps._2021._04._01;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-08-17T13:46:11.670+03:00
 * Generated source version: 3.4.4
 *
 */
@WebService(targetNamespace = "http://kps.nvi.gov.tr/2021/04/01", name = "BilesikKutukSorgulaKimlikNoServis")
@XmlSeeAlso({com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, tr.gov.nvi.kps._2011._01._01.ObjectFactory.class, org.datacontract.schemas._2004._07.common_types.ObjectFactory.class, ObjectFactory.class})
public interface BilesikKutukSorgulaKimlikNoServis {

    @WebMethod(operationName = "Sorgula", action = "http://kps.nvi.gov.tr/2021/04/01/BilesikKutukSorgulaKimlikNoServis/Sorgula")
    @Action(input = "http://kps.nvi.gov.tr/2021/04/01/BilesikKutukSorgulaKimlikNoServis/Sorgula", output = "http://kps.nvi.gov.tr/2021/04/01/BilesikKutukSorgulaKimlikNoServis/SorgulaResponse")
    @RequestWrapper(localName = "Sorgula", targetNamespace = "http://kps.nvi.gov.tr/2021/04/01", className = "tr.gov.nvi.kps._2021._04._01.Sorgula")
    @ResponseWrapper(localName = "SorgulaResponse", targetNamespace = "http://kps.nvi.gov.tr/2021/04/01", className = "tr.gov.nvi.kps._2021._04._01.SorgulaResponse")
    @WebResult(name = "SorgulaResult", targetNamespace = "http://kps.nvi.gov.tr/2021/04/01")
    public tr.gov.nvi.kps._2021._04._01.BilesikKutukBilgileriSonucu sorgula(

        @WebParam(name = "kriterListesi", targetNamespace = "http://kps.nvi.gov.tr/2021/04/01")
        tr.gov.nvi.kps._2021._04._01.ArrayOfBilesikKutukSorgulaKimlikNoSorguKriteri kriterListesi
    );
}
