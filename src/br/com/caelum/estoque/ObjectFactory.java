
package br.com.caelum.estoque;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.caelum.estoque package. 
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

    private final static QName _ItemsByCodeResponse_QNAME = new QName("http://caelum.com.br/stockws/v1", "itemsByCodeResponse");
    private final static QName _AuthorizationException_QNAME = new QName("http://caelum.com.br/stockws/v1", "AuthorizationException");
    private final static QName _BlablaResponse_QNAME = new QName("http://caelum.com.br/stockws/v1", "blablaResponse");
    private final static QName _ItemByCodeResponse_QNAME = new QName("http://caelum.com.br/stockws/v1", "itemByCodeResponse");
    private final static QName _TokenAuthorization_QNAME = new QName("http://caelum.com.br/stockws/v1", "TokenAuthorization");
    private final static QName _Item_QNAME = new QName("http://caelum.com.br/stockws/v1", "item");
    private final static QName _ItemByCode_QNAME = new QName("http://caelum.com.br/stockws/v1", "itemByCode");
    private final static QName _Token_QNAME = new QName("http://caelum.com.br/stockws/v1", "token");
    private final static QName _ItemsByCode_QNAME = new QName("http://caelum.com.br/stockws/v1", "itemsByCode");
    private final static QName _Blabla_QNAME = new QName("http://caelum.com.br/stockws/v1", "blabla");
    private final static QName _ReturnedItem_QNAME = new QName("returnedItemResponse", "returnedItem");
    private final static QName _ItemResponse_QNAME = new QName("http://caelum.com.br/stockws/v1", "itemResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.caelum.estoque
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link TokenAuthorization }
     * 
     */
    public TokenAuthorization createTokenAuthorization() {
        return new TokenAuthorization();
    }

    /**
     * Create an instance of {@link BlablaResponse }
     * 
     */
    public BlablaResponse createBlablaResponse() {
        return new BlablaResponse();
    }

    /**
     * Create an instance of {@link ItemByCodeResponse }
     * 
     */
    public ItemByCodeResponse createItemByCodeResponse() {
        return new ItemByCodeResponse();
    }

    /**
     * Create an instance of {@link AuthorizationException }
     * 
     */
    public AuthorizationException createAuthorizationException() {
        return new AuthorizationException();
    }

    /**
     * Create an instance of {@link ItemsByCodeResponse }
     * 
     */
    public ItemsByCodeResponse createItemsByCodeResponse() {
        return new ItemsByCodeResponse();
    }

    /**
     * Create an instance of {@link ItemResponse }
     * 
     */
    public ItemResponse createItemResponse() {
        return new ItemResponse();
    }

    /**
     * Create an instance of {@link Blabla }
     * 
     */
    public Blabla createBlabla() {
        return new Blabla();
    }

    /**
     * Create an instance of {@link ItemsByCode }
     * 
     */
    public ItemsByCode createItemsByCode() {
        return new ItemsByCode();
    }

    /**
     * Create an instance of {@link ItemByCode }
     * 
     */
    public ItemByCode createItemByCode() {
        return new ItemByCode();
    }

    /**
     * Create an instance of {@link StockItem }
     * 
     */
    public StockItem createStockItem() {
        return new StockItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemsByCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "itemsByCodeResponse")
    public JAXBElement<ItemsByCodeResponse> createItemsByCodeResponse(ItemsByCodeResponse value) {
        return new JAXBElement<ItemsByCodeResponse>(_ItemsByCodeResponse_QNAME, ItemsByCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "AuthorizationException")
    public JAXBElement<AuthorizationException> createAuthorizationException(AuthorizationException value) {
        return new JAXBElement<AuthorizationException>(_AuthorizationException_QNAME, AuthorizationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BlablaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "blablaResponse")
    public JAXBElement<BlablaResponse> createBlablaResponse(BlablaResponse value) {
        return new JAXBElement<BlablaResponse>(_BlablaResponse_QNAME, BlablaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemByCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "itemByCodeResponse")
    public JAXBElement<ItemByCodeResponse> createItemByCodeResponse(ItemByCodeResponse value) {
        return new JAXBElement<ItemByCodeResponse>(_ItemByCodeResponse_QNAME, ItemByCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenAuthorization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "TokenAuthorization")
    public JAXBElement<TokenAuthorization> createTokenAuthorization(TokenAuthorization value) {
        return new JAXBElement<TokenAuthorization>(_TokenAuthorization_QNAME, TokenAuthorization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemByCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "itemByCode")
    public JAXBElement<ItemByCode> createItemByCode(ItemByCode value) {
        return new JAXBElement<ItemByCode>(_ItemByCode_QNAME, ItemByCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "token")
    public JAXBElement<String> createToken(String value) {
        return new JAXBElement<String>(_Token_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemsByCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "itemsByCode")
    public JAXBElement<ItemsByCode> createItemsByCode(ItemsByCode value) {
        return new JAXBElement<ItemsByCode>(_ItemsByCode_QNAME, ItemsByCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Blabla }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "blabla")
    public JAXBElement<Blabla> createBlabla(Blabla value) {
        return new JAXBElement<Blabla>(_Blabla_QNAME, Blabla.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StockItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "returnedItemResponse", name = "returnedItem")
    public JAXBElement<StockItem> createReturnedItem(StockItem value) {
        return new JAXBElement<StockItem>(_ReturnedItem_QNAME, StockItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/stockws/v1", name = "itemResponse")
    public JAXBElement<ItemResponse> createItemResponse(ItemResponse value) {
        return new JAXBElement<ItemResponse>(_ItemResponse_QNAME, ItemResponse.class, null, value);
    }

}
