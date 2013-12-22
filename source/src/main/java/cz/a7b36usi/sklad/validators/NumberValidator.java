package cz.a7b36usi.sklad.validators;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
