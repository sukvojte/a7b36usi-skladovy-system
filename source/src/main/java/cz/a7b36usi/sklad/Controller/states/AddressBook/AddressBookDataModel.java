package cz.a7b36usi.sklad.Controller.states.AddressBook;

import java.util.List;

import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class AddressBookDataModel extends BaseDataModel<ZakaznikDTO> {

    private static final long serialVersionUID = -3796057684382082727L;

    public AddressBookDataModel(List<ZakaznikDTO> list) {
        super(list);
        columns = new Column[]{new Column("Spolecnost"), new Column("Mesto"), new Column("Ulice")};
    }

    @Override
    public Object getColumnValue(ZakaznikDTO row, int index) {
        switch (index) {
            case 0:
                return row.getSpolecnost();
            case 1:
                return row.getMesto();
            case 2:
                return row.getUlice();
            default:
                return null;
        }
    }

}
