package cz.a7b36usi.sklad.Controller.states.documents;

import cz.a7b36usi.sklad.DTO.DocumentDTO;
import java.util.List;

import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import cz.a7b36usi.sklad.tableutils.Column;

public class DocumentsDataModel extends BaseDataModel<DocumentDTO> {

    private static final long serialVersionUID = -34382082727L;

    public DocumentsDataModel(List<DocumentDTO> list) {
        super(list);
        columns = new Column[]{new Column("Typ dokumentu"), new Column("Zakaznik"), new Column("Datum"), new Column("Kod")};
    }

    @Override
    public Object getColumnValue(DocumentDTO row, int index) {
        switch (index) {
            case 0:
                return row.getDocumentType();
            case 1:
                return row.getPartner();
            case 2:
                return row.getDate();
            case 3:
                return row.getNumber();	
            default:
                return null;
        }
    }

}
