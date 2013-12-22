package cz.a7b36usi.sklad.Controller.states.order;

import java.util.List;

import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class OrdersDataModel extends BaseDataModel<OrderDTO> {

	private static final long serialVersionUID = 6351160056712231231L;

	public OrdersDataModel(List<OrderDTO> list) {
		super(list);
		columns = new Column[] { new Column("Cislo objednavky"),
				new Column("Datum"), new Column("Partner") };
	}

	@Override
	public Object getColumnValue(OrderDTO row, int index) {
		switch (index) {
		case 0:
			return row.getNumber();
		case 1:
			return row.getDate();
		case 2:
			return row.getPartner();
		default:
			return null;
		}

	}

}
