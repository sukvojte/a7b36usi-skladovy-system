package cz.a7b36usi.sklad.gui;

import cz.a7b36usi.sklad.DTO.ProductDTO;

public class ComboBoxProductItem {

	private ProductDTO product;
	
	public ComboBoxProductItem(ProductDTO product) {
		this.product = product;
	}

	/**
	 * @return the product
	 */
	public ProductDTO getProduct() {
		return product;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof ProductDTO){
			return product.equals(obj);
		}
		
		if(obj instanceof Long){
			return product.getId().equals(obj);
		}
		
		return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return product.getName();
	}
	
	
	

}
