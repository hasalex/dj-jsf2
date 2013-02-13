package fr.sewatech.formation.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		if ( !(value instanceof String) ) {
			return;
		}
		
		String text = (String) value;
		if (text.startsWith("!") && !text.endsWith("!")) {
			throw new ValidatorException(new FacesMessage("Problème de !"));
		}
	}

}
