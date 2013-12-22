/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Helper;

import java.util.ArrayList;
import java.util.List;

import cz.a7b36usi.sklad.BO.AbstractBO;

/**
 * This class is id resolver, which transform list of AbstractBOs to their ID's
 * list.
 * 
 * @author Peter
 */
public class IdResolver {

	public static List<Long> getIdentifiers(List<? extends AbstractBO> list) {
		if (list == null) {
			return null;
		}
		List<Long> ids = new ArrayList<Long>();

		for (AbstractBO abo : list) {
			ids.add(abo.getId());
		}
		return ids;
	}

}
