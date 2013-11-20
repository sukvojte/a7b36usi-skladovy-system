package cz.a7b36usi.sklad.tableutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TableBindingList<T> implements List<T> {
	
	private List<T> base;
	private List<TableListener> listeners;
	
	public TableBindingList(List<T> base){
		this.base = base;
		this.listeners = new ArrayList<TableListener>();
	}

	public int size() {
		return base.size();
	}

	public boolean isEmpty() {
		return base.isEmpty();
	}

	public boolean contains(Object o) {
		return base.contains(o);
	}

	public Iterator<T> iterator() {
		return base.iterator();
	}

	public Object[] toArray() {
		return base.toArray();
	}

	public <U> U[] toArray(U[] a) {
		return base.toArray(a);
	}

	public boolean add(T e) {
		boolean state = base.add(e);
		if(state){
			fireListeners(new TableEvent(TableEvent.Type.ALL));
		}
		return state;
	}

	public boolean remove(Object o) {
		boolean state = base.remove(o); 
		if(state){
			fireListeners(new TableEvent(TableEvent.Type.ALL));
		}
		return state;
	}

	public boolean containsAll(Collection<?> c) {
		return base.containsAll(c);
	}

	public boolean addAll(Collection<? extends T> c) {
		return base.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends T> c) {
		return base.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return base.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return base.retainAll(c);
	}

	public void clear() {
		base.clear();
		fireListeners(new TableEvent(TableEvent.Type.ALL));
	}

	public T get(int index) {
		return base.get(index);
	}

	public T set(int index, T element) {
		T obj = base.set(index, element);
		fireListeners(new TableEvent(TableEvent.Type.UPDATE, index));
		return obj;
	}

	public void add(int index, T element) {
		base.add(index, element);
		fireListeners(new TableEvent(TableEvent.Type.INSERT, index));
	}

	public T remove(int index) {
		T obj = base.remove(index);
		fireListeners(new TableEvent(TableEvent.Type.INSERT, index));
		return obj;
	}

	public int indexOf(Object o) {
		return base.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return base.lastIndexOf(o);
	}

	public ListIterator<T> listIterator() {
		return base.listIterator();
	}

	public ListIterator<T> listIterator(int index) {
		return base.listIterator(index);
	}

	public List<T> subList(int fromIndex, int toIndex) {
		return base.subList(fromIndex, toIndex);
	}
	
	public void addTableListener(TableListener l) {
    	this.listeners.add(l);
    }

    public void removeTableListener(TableListener l) {
    	this.listeners.remove(l);
    }
    
    public void fireListeners(TableEvent e){
    	for(TableListener l : listeners){
    		l.tableChanged(e);
    	}
    }
	
}
