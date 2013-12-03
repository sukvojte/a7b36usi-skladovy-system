package cz.a7b36usi.sklad.validators;

import cz.a7b36usi.sklad.DTO.UserDTO;
import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Lukas L.
 */
public class NumberValidator extends AbstractValidator {

    public NumberValidator(JLabel errorJL, String message) {
        super(errorJL, message);
    }

    @Override
    public boolean verify(JComponent c) {
        String text = ((JTextField) c).getText();
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return incorrect(c);
        }
        return correct(c);
    }
}
