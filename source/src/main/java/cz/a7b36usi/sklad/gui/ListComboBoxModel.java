package cz.a7b36usi.sklad.gui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import cz.a7b36usi.sklad.DTO.AbstractDTO;


public class ListComboBoxModel<T extends AbstractDTO> extends AbstractListModel<T> implements ComboBoxModel<T>{

	private static final long serialVersionUID = -108109237683408818L;

	private List<T> products;
	private T selected;
	
	private Class<?> type;
	
	public ListComboBoxModel(List<T> products, Class<?> type){
		this.products = products;
		this.type = type;
	}
	
	public T getElementAt(int index) {
		return products.get(index);
	}

	public int getSize() {
		return products.size();
	}

	public T getSelectedItem() {
		return selected;
	}

	@SuppressWarnings("unchecked")
	public void setSelectedItem(Object anItem) {
		selected = null;
		
		if(type.isInstance(anItem)){
			selected = (T)anItem;
		}else if((anItem instanceof Long) || (anItem instanceof Integer)){
			selected = getById((Long)anItem);
		}
	}

	public T getById(long id){
		
		for(T dto : products){
			if(dto.getId().equals(id)){
				return dto;
			}
		}
		return null;
	}
	
	public Long getActiveId(){
		if(selected != null){
			return selected.getId();
		}
		return Long.valueOf(0);
	}
	

}
