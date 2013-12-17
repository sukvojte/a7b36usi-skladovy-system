package cz.a7b36usi.sklad.Controller.states.movements;

import cz.a7b36usi.sklad.DTO.MovementDTO;
import java.util.List;

import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class MovementsDataModel extends BaseDataModel<MovementDTO> {

    private static final long serialVersionUID = -3438208232432727L;

    public MovementsDataModel(List<MovementDTO> list) {
        super(list);
        columns = new Column[]{new Column("Spolecnost"), new Column("Mesto"), new Column("Ulice")};
    }

    @Override
    public Object getColumnValue(MovementDTO row, int index) {
        switch (index) {
            case 0:
                return null;//TODO: vracet stringy
            case 1:
                return null;
            case 2:
                return null;
            default:
                return null;
        }
    }

}
