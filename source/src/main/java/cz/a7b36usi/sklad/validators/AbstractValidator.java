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
public abstract class AbstractValidator extends InputVerifier {

    protected JLabel errorJL;
    protected String message;

    public AbstractValidator(JLabel errorJL, String message) {
        this.errorJL = errorJL;
        this.message = message;
        this.errorJL.setVisible(false);
    }

    protected boolean correct(JComponent c) {
        errorJL.setVisible(false);
        c.setBackground(Color.WHITE);
        return true;
    }

    protected boolean incorrect(JComponent c) {
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
