
package br.com.caelum.estoque;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itemResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{returnedItemResponse}returnedItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemResponse", propOrder = {
    "returnedItem"
})
public class ItemResponse {

    @XmlElement(namespace = "returnedItemResponse")
    protected StockItem returnedItem;

    /**
     * Gets the value of the returnedItem property.
     * 
     * @return
     *     possible object is
     *     {@link StockItem }
     *     
     */
    public StockItem getReturnedItem() {
        return returnedItem;
    }

    /**
     * Sets the value of the returnedItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockItem }
     *     
     */
    public void setReturnedItem(StockItem value) {
        this.returnedItem = value;
    }

}
