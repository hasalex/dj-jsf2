package fr.sewatech.formation.jsf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("mfdc")
public class MultiFormatDateConverter implements Converter{
	
	private SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
	private SimpleDateFormat[] inputFormat = new SimpleDateFormat[] {new SimpleDateFormat("dd/MM/yyyy"),
																	 new SimpleDateFormat("dd/MM/yy")};
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String text) {
		text = text.replaceAll("-", "/");
		Date result = null;
		for (SimpleDateFormat formatter : inputFormat) {
			try {
				result = formatter.parse(text);
				break;
			} catch (ParseException e) {
			}
		}
		if (result == null) {
			throw new ConverterException(new FacesMessage("Pas une date"));
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (component instanceof UIInput) {
			return inputFormat[0].format(value);			
		} else {
			return outputFormat.format(value);
		}
	}
	
}
