package cz.a7b36usi.sklad.gui.orderitems;

import java.util.List;

import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class OrderItemsDataModel extends BaseDataModel<OrderItemDTO> {

	private static final long serialVersionUID = 8336156421342838673L;

	public OrderItemsDataModel(List<OrderItemDTO> list) {
		super(list);
		columns = new Column[] { new Column("Produkt"), new Column("Počet") };
	}

	@Override
	public Object getColumnValue(OrderItemDTO row, int index) {
		switch (index) {
		case 0:
			return row.getProductName();
		case 1:
			return row.getQuantity();
		default:
			return null;
		}

	}

}
