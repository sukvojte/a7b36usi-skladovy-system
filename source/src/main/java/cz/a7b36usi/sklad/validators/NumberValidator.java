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
public class NumberValidator extends InputVerifier {

    private JLabel errorJL;
    public String message;

    public NumberValidator(JLabel errorJL, String message) {
        this.errorJL = errorJL;
        this.message = message;
        this.errorJL.setVisible(false);
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

    private boolean correct(JComponent c) {
        errorJL.setVisible(false);
        c.setBackground(Color.WHITE);
        return true;
    }

    private boolean incorrect(JComponent c) {
        errorJL.setText(message);
        errorJL.setVisible(true);
        c.setBackground(Color.pink);
        return false;
    }

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        return true;
    }
    
}
