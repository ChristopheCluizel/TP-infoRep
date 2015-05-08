
package hellowebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hellowebservice package. 
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

    private final static QName _EntierNegatif_QNAME = new QName("http://helloWebService/", "EntierNegatif");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hellowebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EntierNegatif }
     * 
     */
    public EntierNegatif createEntierNegatif() {
        return new EntierNegatif();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntierNegatif }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://helloWebService/", name = "EntierNegatif")
    public JAXBElement<EntierNegatif> createEntierNegatif(EntierNegatif value) {
        return new JAXBElement<EntierNegatif>(_EntierNegatif_QNAME, EntierNegatif.class, null, value);
    }

}
