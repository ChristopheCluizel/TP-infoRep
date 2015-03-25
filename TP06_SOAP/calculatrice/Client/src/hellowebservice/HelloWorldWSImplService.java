package hellowebservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2015-03-25T16:56:40.560+01:00
 * Generated source version: 2.4.6
 * 
 */
@WebServiceClient(name = "HelloWorldWSImplService", 
                  wsdlLocation = "http://localhost:8080/HelloWorldWebService/HelloWorldWS?wsdl",
                  targetNamespace = "http://helloWebService/") 
public class HelloWorldWSImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://helloWebService/", "HelloWorldWSImplService");
    public final static QName HelloWorldWSImplPort = new QName("http://helloWebService/", "HelloWorldWSImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/HelloWorldWebService/HelloWorldWS?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HelloWorldWSImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/HelloWorldWebService/HelloWorldWS?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HelloWorldWSImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HelloWorldWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldWSImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public HelloWorldWSImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public HelloWorldWSImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public HelloWorldWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns HelloWorldWS
     */
    @WebEndpoint(name = "HelloWorldWSImplPort")
    public HelloWorldWS getHelloWorldWSImplPort() {
        return super.getPort(HelloWorldWSImplPort, HelloWorldWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorldWS
     */
    @WebEndpoint(name = "HelloWorldWSImplPort")
    public HelloWorldWS getHelloWorldWSImplPort(WebServiceFeature... features) {
        return super.getPort(HelloWorldWSImplPort, HelloWorldWS.class, features);
    }

}
