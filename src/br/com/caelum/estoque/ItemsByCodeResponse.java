
package br.com.caelum.estoque;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itemsByCodeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemsByCodeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stockItems" type="{http://caelum.com.br/stockws/v1}stockItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemsByCodeResponse", propOrder = {
    "stockItems"
})
public class ItemsByCodeResponse {

    protected List<StockItem> stockItems;

    /**
     * Gets the value of the stockItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stockItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStockItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StockItem }
     * 
     * 
     */
    public List<StockItem> getStockItems() {
        if (stockItems == null) {
            stockItems = new ArrayList<StockItem>();
        }
        return this.stockItems;
    }

}
