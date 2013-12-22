package cz.a7b36usi.sklad.Controller.states.products;

import java.util.List;

import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class ProductsDataModel extends BaseDataModel<ProductDTO> {

	private static final long serialVersionUID = -34382434332432727L;

	public ProductsDataModel(List<ProductDTO> list) {
		super(list);
		columns = new Column[] { new Column("Kod"),
				new Column("Jmeno produktu"), new Column("Mnozstvi") };
	}

	@Override
	public Object getColumnValue(ProductDTO row, int index) {
		switch (index) {
		case 0:
			return row.getCode();
		case 1:
			return row.getName();
		case 2:
			return row.getQuantity();
		default:
			return null;
		}
	}

}
