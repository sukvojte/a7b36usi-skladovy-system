/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.OrderBO;
import cz.a7b36usi.sklad.BO.OrderItemBO;
import cz.a7b36usi.sklad.BO.PartnerBO;
import cz.a7b36usi.sklad.BO.ProductBO;
import cz.a7b36usi.sklad.BO.ProductVersionBO;
import cz.a7b36usi.sklad.BO.WrappingTypeBO;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Peter
 */
@Component
public class OrderService extends AbstractService implements IOrderService {

    public void saveOrder(OrderDTO order) {
        OrderBO bo = new OrderBO();
        bo.setDate(order.getDate());
        bo.setId(order.getId());
        bo.setPartner(genericDAO.loadById(order.getPartner(), PartnerBO.class));
        List<OrderItemBO> items = new ArrayList<OrderItemBO>();
        for (OrderItemDTO orderItemDTO : order.getItems()) {
            OrderItemBO it = new OrderItemBO();
            it.setOrder(bo);
            it.setProduct(genericDAO.loadById(orderItemDTO.getProduct(), ProductBO.class));
            it.setProductVersion(genericDAO.loadById(orderItemDTO.getProductVersion(), ProductVersionBO.class));
            it.setQuantity(orderItemDTO.getQuantity());
            it.setWrappingType(genericDAO.loadById(orderItemDTO.getWrappingType(), WrappingTypeBO.class));
            items.add(it);
        }
        genericDAO.saveOrUpdate(bo);
    }

    public List<OrderDTO> getAllOrders() {
        List<OrderBO> bos = genericDAO.getAll(OrderBO.class);
        List<OrderDTO> odtos = new ArrayList<OrderDTO>();

        for (OrderBO orderBO : bos) {
            List<OrderItemDTO> idtos = new ArrayList<OrderItemDTO>();
            for (OrderItemBO orderItemBO : orderBO.getItems()) {
                OrderItemDTO idto = new OrderItemDTO(
                        orderItemBO.getId(),
                        orderItemBO.getProduct().getId(),
                        orderItemBO.getQuantity(),
                        orderItemBO.getWrappingType().getId(),
                        orderItemBO.getProductVersion().getId(),
                        orderItemBO.getOrder().getId());
                idtos.add(idto);
            }

            OrderDTO dto = new OrderDTO(orderBO.getId(), orderBO.getDate(), idtos, orderBO.getPartner().getId());
            odtos.add(dto);
        }
        return odtos;
    }

    public void removeOrder(OrderDTO order) {
        genericDAO.removeById(order.getId(), OrderBO.class);
    }

    public void saveOrderItem(OrderItemDTO item) {
        OrderItemBO it = new OrderItemBO();
        it.setOrder(genericDAO.loadById(item.getOrder(), OrderBO.class));
        it.setProduct(genericDAO.loadById(item.getProduct(), ProductBO.class));
        it.setProductVersion(genericDAO.loadById(item.getProductVersion(), ProductVersionBO.class));
        it.setQuantity(item.getQuantity());
        it.setWrappingType(genericDAO.loadById(item.getWrappingType(), WrappingTypeBO.class));
        genericDAO.saveOrUpdate(it);
    }

    public List<OrderItemDTO> getAllOrderItems(OrderDTO order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeOrderItem(OrderItemDTO item) {
        genericDAO.removeById(item.getId(), OrderItemBO.class);
    }

    public OrderItemDTO getOrderItemById(Long id) {
        OrderItemBO orderItemBO = genericDAO.loadById(id, OrderItemBO.class);
        OrderItemDTO idto = new OrderItemDTO(
                orderItemBO.getId(),
                orderItemBO.getProduct().getId(),
                orderItemBO.getQuantity(),
                orderItemBO.getWrappingType().getId(),
                orderItemBO.getProductVersion().getId(),
                orderItemBO.getOrder().getId());
        return idto;
    }

}
