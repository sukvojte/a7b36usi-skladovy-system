package cz.a7b36usi.sklad.Controller.states.users;

import java.util.List;

import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public class UsersDataModel extends BaseDataModel<UserDTO>{

	private static final long serialVersionUID = -749847976262513097L;
	
	public UsersDataModel(List<UserDTO> list) {
		super(list);
		columns = new String[]{"Jmeno","Role"};
	}

	@Override
	public Object getColumnValue(UserDTO row, int index) {
		switch(index){
		case 0:
			return row.getUsername();
		case 1:
			return row.getAcl();
		}
		return null;
	}

	

}
