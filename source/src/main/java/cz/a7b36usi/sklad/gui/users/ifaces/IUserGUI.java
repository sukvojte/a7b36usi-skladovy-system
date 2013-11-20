/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.gui.users.ifaces;

import cz.a7b36usi.sklad.DTO.UserDTO;

/**
 *
 * @author Vojta
 */
public interface IUserGUI {
    void setVisible(boolean state);
    void setUser(UserDTO user);
}
