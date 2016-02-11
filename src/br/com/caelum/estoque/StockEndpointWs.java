
package br.com.caelum.estoque;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StockEndpointWs", targetNamespace = "http://caelum.com.br/stockws/v1")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StockEndpointWs {


    /**
     * 
     * @param code
     * @param token
     * @return
     *     returns br.com.caelum.estoque.StockItem
     * @throws AuthorizationException_Exception
     */
    @WebMethod
    @WebResult(name = "stockItem", targetNamespace = "")
    @RequestWrapper(localName = "itemByCode", targetNamespace = "http://caelum.com.br/stockws/v1", className = "br.com.caelum.estoque.ItemByCode")
    @ResponseWrapper(localName = "itemByCodeResponse", targetNamespace = "http://caelum.com.br/stockws/v1", className = "br.com.caelum.estoque.ItemByCodeResponse")
    public StockItem itemByCode(
        @WebParam(name = "token", targetNamespace = "")
        String token,
        @WebParam(name = "code", targetNamespace = "")
        String code)
        throws AuthorizationException_Exception
    ;

    /**
     * 
     * @param parameters
     * @param token
     * @return
     *     returns br.com.caelum.estoque.ItemsByCodeResponse
     * @throws AuthorizationTokenException
     */
    @WebMethod
    @WebResult(name = "itemsByCodeResponse", targetNamespace = "http://caelum.com.br/stockws/v1", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public ItemsByCodeResponse itemsByCode(
        @WebParam(name = "itemsByCode", targetNamespace = "http://caelum.com.br/stockws/v1", partName = "parameters")
        ItemsByCode parameters,
        @WebParam(name = "token", targetNamespace = "http://caelum.com.br/stockws/v1", header = true, partName = "token")
        String token)
        throws AuthorizationTokenException
    ;

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "blabla", targetNamespace = "http://caelum.com.br/stockws/v1", className = "br.com.caelum.estoque.Blabla")
    @ResponseWrapper(localName = "blablaResponse", targetNamespace = "http://caelum.com.br/stockws/v1", className = "br.com.caelum.estoque.BlablaResponse")
    public void blabla();

    /**
     * 
     * @param code
     * @return
     *     returns br.com.caelum.estoque.StockItem
     */
    @WebMethod
    @WebResult(name = "returnedItem", targetNamespace = "returnedItemResponse")
    @RequestWrapper(localName = "item", targetNamespace = "http://caelum.com.br/stockws/v1", className = "br.com.caelum.estoque.Item")
    @ResponseWrapper(localName = "itemResponse", targetNamespace = "http://caelum.com.br/stockws/v1", className = "br.com.caelum.estoque.ItemResponse")
    public StockItem item(
        @WebParam(name = "code", targetNamespace = "")
        String code);

}
