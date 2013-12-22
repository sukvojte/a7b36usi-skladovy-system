package cz.a7b36usi.sklad.validators;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Lukas L.
 */
public class UserNameValidator extends AbstractValidator {

	public UserNameValidator(JLabel errorJL, String message) {
		super(errorJL, message);
	}

	private String value;

	@Override
	public boolean verify(JComponent c) {
		String text = ((JTextField) c).getText();
		if (text.equals("") || text.equals(value)) {
			return incorrect(c);
		}

		return correct(c);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String v) {
		value = v;
	}
}
