
package hellowebservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for complexe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="complexe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="im" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="re" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "complexe", propOrder = {
    "im",
    "re"
})
public class Complexe {

    protected double im;
    protected double re;

    /**
     * Gets the value of the im property.
     * 
     */
    public double getIm() {
        return im;
    }

    /**
     * Sets the value of the im property.
     * 
     */
    public void setIm(double value) {
        this.im = value;
    }

    /**
     * Gets the value of the re property.
     * 
     */
    public double getRe() {
        return re;
    }

    /**
     * Sets the value of the re property.
     * 
     */
    public void setRe(double value) {
        this.re = value;
    }

}
