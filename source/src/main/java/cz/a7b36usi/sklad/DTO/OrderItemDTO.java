/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

import cz.a7b36usi.sklad.BO.OrderItemBO;

/**
 *
 * @author Peter
 */
public class OrderItemDTO extends AbstractDTO{
    private Long productId;
    private String productName;
    private int quantity;
    private Long wrappingType;
    private Long productVersion;
    private Long order;

    
    /**
     * 
     * @param id
     * @param product           product contained in this item
     * @param quantity          how many products is contained in this item
     * @param wrappingType      type of packaging
     * @param productVersion    version of product
     * @param order             order in which is this particular item being held
     */
    public OrderItemDTO(Long id,Long product, int quantity, Long wrappingType, Long productVersion, Long order) {
        this.productId = product;
        this.quantity = quantity;
        this.wrappingType = wrappingType;
        this.productVersion = productVersion;
        this.order = order;
        this.id=id;
    }

    public OrderItemDTO() {
    	this.id = null;
	}
	
    public OrderItemDTO(OrderItemBO orderItemBO, Long order) {
    	
    	if(orderItemBO.getProduct() != null){
    		this.productId = orderItemBO.getProduct().getId();
    		this.productName = orderItemBO.getProduct().getName();
    	}
    	
        this.quantity = orderItemBO.getQuantity();
        
        if(orderItemBO.getWrappingType() != null)
        	this.wrappingType = orderItemBO.getWrappingType().getId();
        
        if(orderItemBO.getProductVersion() != null)
        	this.productVersion = orderItemBO.getProductVersion().getId();
        
        this.order = order;
        this.id  = orderItemBO.getId();

	}

	//GETTERS AND SETTERS
    public Long getProduct() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProduct(Long product) {
        this.productId = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getWrappingType() {
        return wrappingType;
    }

    public void setWrappingType(Long wrappingType) {
        this.wrappingType = wrappingType;
    }

    public Long getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(Long productVersion) {
        this.productVersion = productVersion;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }
    
    
}
