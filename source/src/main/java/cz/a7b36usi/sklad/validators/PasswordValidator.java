
package cz.a7b36usi.sklad.validators;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author Lukas L.
 */
public class PasswordValidator extends AbstractValidator{

    public PasswordValidator(JLabel errorJL, String message) {
        super(errorJL, message);
    }

    
    @Override
    public boolean verify(JComponent c) {
        String text = new String(((JPasswordField) c).getPassword());
        if (text.equals("")) {
            return incorrect(c);
        }

        return correct(c);
    }

}
