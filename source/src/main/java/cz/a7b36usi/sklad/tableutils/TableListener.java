package cz.a7b36usi.sklad.tableutils;

import java.util.EventListener;

public interface TableListener extends EventListener {
	     public void tableChanged(TableEvent e);
}
