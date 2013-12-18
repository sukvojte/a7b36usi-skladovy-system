package cz.a7b36usi.sklad.gui.documentitems;

import java.util.List;

import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class DocumentItemsDataModel extends BaseDataModel<MovementDTO> {

	private static final long serialVersionUID = 1906059355967682244L;

	public DocumentItemsDataModel(List<MovementDTO> list) {
		super(list);
		columns = new Column[] { new Column("Produkt"), new Column("Počet"),
				new Column("Cena")};
	}

	@Override
	public Object getColumnValue(MovementDTO row, int index) {
		switch (index) {
		case 0:
			return row.getProdukt().getName();
		case 1:
			return null;
		case 2:
			return row.getPrice();
		default:
			return null;
		}

	}

}
