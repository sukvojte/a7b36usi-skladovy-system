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
public class ValueValidator extends AbstractValidator {

    private String value;
    public ValueValidator(JLabel errorJL, String value, String message) {
        super(errorJL, message);
        this.value = value;
    }

    @Override
    public boolean verify(JComponent c) {
        String text = ((JTextField) c).getText();
        if (text.equals(value)) {
            return incorrect(c);
        }

        return correct(c);
    }
}
