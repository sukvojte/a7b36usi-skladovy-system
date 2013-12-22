/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

/**
 * 
 * @author Peter
 */
public class WrappingTypeDTO extends AbstractDTO {

	private String name;
	private Double quantity;

	private Long product;

	public WrappingTypeDTO(Long id, String name, Double quantity, Long product) {
		this.name = name;
		this.quantity = quantity;
		this.product = product;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

}
