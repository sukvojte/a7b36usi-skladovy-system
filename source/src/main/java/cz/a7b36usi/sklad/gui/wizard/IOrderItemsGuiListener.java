package cz.a7b36usi.sklad.gui.wizard;

import cz.a7b36usi.sklad.DTO.OrderItemDTO;

public interface IOrderItemsGuiListener {
	void save(OrderItemDTO orderItem);
	void click(int index);
}
