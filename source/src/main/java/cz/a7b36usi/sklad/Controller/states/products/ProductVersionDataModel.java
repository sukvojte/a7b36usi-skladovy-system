package cz.a7b36usi.sklad.Controller.states.products;

import java.util.List;

import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class ProductVersionDataModel extends BaseDataModel<ProductVersionDTO> {

	private static final long serialVersionUID = 4157799173696762904L;

	public ProductVersionDataModel(List<ProductVersionDTO> list) {
		super(list);
		columns = new Column[] { new Column("Kod"),
				new Column("Jmeno") };
	}

	@Override
	public Object getColumnValue(ProductVersionDTO row, int index) {
		switch (index) {
		case 0:
			return row.getCode();
		case 1:
			return row.getName();
		default:
			return null;
		}
	}

}
