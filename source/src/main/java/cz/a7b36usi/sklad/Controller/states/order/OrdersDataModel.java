package cz.a7b36usi.sklad.Controller.states.order;

import java.util.List;

import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class OrdersDataModel extends BaseDataModel<OrderDTO> {

	private static final long serialVersionUID = 6351160056712231231L;

	public OrdersDataModel(List<OrderDTO> list) {
        super(list);
        columns = new Column[]{new Column("Datum"), new Column("Role")};
    }

    @Override
    public Object getColumnValue(OrderDTO row, int index) {
        switch (index) {
           
            default:
                return null;
        }

    }

}
