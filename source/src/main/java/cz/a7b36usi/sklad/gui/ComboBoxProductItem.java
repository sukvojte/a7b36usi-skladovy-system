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

	@Override
	public String toString() {
		return product.getName();
	}

}
