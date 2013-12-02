package cz.a7b36usi.sklad.validators;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Lukas L.
 */
public class NoValueValidator extends AbstractValidator {

    public NoValueValidator(JLabel errorJL, String message) {
        super(errorJL, message);
    }

    @Override
    public boolean verify(JComponent c) {
        String text = ((JTextField) c).getText();
        if (text.equals("")) {
            return incorrect(c);
        }

        return correct(c);
    }
}
