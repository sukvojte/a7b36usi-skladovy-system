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
public class ProductVersionDTO extends AbstractDTO {
	private Long code;

	private String name;

	private Long product;

	public ProductVersionDTO(Long id, Long code, String name, Long product) {
		this.code = code;
		this.name = name;
		this.product = product;
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}
        
        public String toString(){
            return this.name+" - "+this.code;
        }
}
