package cz.a7b36usi.sklad.gui.users;

import cz.a7b36usi.sklad.DTO.UserDTO;

public class UserDTO2GUI {

    public static int getFieldCount() {
        return 2;
    }

    public static String[] getFields() {
        return new String[]{"Jmeno", "Opravneni"};
    }

    public static Class<?>[] getFieldTypes() {
        return new Class<?>[]{String.class, String.class};
    }

    public static Object getRowValue(UserDTO userDTO, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return userDTO.getUsername();
            case 1:
                return userDTO.getAcl().toString();
            default:
                return null;
        }

    }

}
