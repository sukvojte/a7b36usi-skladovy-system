package cz.a7b36usi.sklad.Controller.states.products;

import java.util.List;

import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class WrappingTypeDataModel extends BaseDataModel<WrappingTypeDTO> {

	private static final long serialVersionUID = 4157799173696762904L;

	public WrappingTypeDataModel(List<WrappingTypeDTO> list) {
		super(list);
		columns = new Column[] { new Column("Mnozstvi"),
				new Column("Jmeno") };
	}

	@Override
	public Object getColumnValue(WrappingTypeDTO row, int index) {
		switch (index) {
		case 0:
			return row.getQuantity();
		case 1:
			return row.getName();
		default:
			return null;
		}
	}

}
