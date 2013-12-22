/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;

/**
 * 
 * @author Peter
 */
public interface IOrderService {

	/**
	 * Persists order in database
	 * 
	 * @param order
	 *            order to be persistedd
	 */
	public Long saveOrder(OrderDTO order);

	/**
	 * 
	 * @return all orders
	 */
	@Transactional(readOnly = true)
	public List<OrderDTO> getAllOrders();

	/**
	 * Removes order and all of its items from database
	 * 
	 * @param order
	 *            order to be removed
	 */
	public void removeOrder(OrderDTO order);

	/**
	 * Saves order item
	 * 
	 * @param item
	 *            order item to be saved
	 */
	public void saveOrderItem(OrderItemDTO item);

	/**
	 * 
	 * @param id
	 *            identifier of order item to be retrieved
	 * @return Order item
	 */
	@Transactional(readOnly = true)
	public OrderItemDTO getOrderItemById(Long id);

	/**
	 * 
	 * @param order
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<OrderItemDTO> getAllOrderItems(OrderDTO order);

	/**
	 * 
	 * @param item
	 */
	public void removeOrderItem(OrderItemDTO item);

	/**
	 * 
	 * @return
	 */
	public List<OrderItemDTO> getOrderItems(OrderDTO item);

}
