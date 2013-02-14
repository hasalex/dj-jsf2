package fr.sewatech.formation.jsf;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.librairie.dao.CategorieDao;
import org.librairie.dao.ProduitDao;
import org.librairie.model.Categorie;

@ManagedBean(eager = true)
@ApplicationScoped
public class GlobalBean {
	private ProduitDao produitDao;
	private CategorieDao categorieDao;

	private List<SelectItem> allCategoryItems = new ArrayList<SelectItem>();

	@PostConstruct
	public void init() {
		produitDao = new ProduitDao();
		categorieDao = new CategorieDao();

		Collection<Categorie> allCategories = categorieDao.findAllCategories();
		for (Categorie categorie : allCategories) {
			allCategoryItems.add(new SelectItem(categorie.getId(), categorie
					.getDescription()));
		}
	}

	public ProduitDao getProduitDao() {
		return produitDao;
	}

	public CategorieDao getCategorieDao() {
		return categorieDao;
	}

	public List<SelectItem> getAllCategoryItems() {
		return allCategoryItems;
	}

	public static String getDisplayString(String bundleName, String key, Locale locale, Object... params) {
		String text = null;
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
		try {
			text = bundle.getString(key);
		} catch (MissingResourceException mre) {
			text = "???" + key + "???";
		}

		if (params != null) {
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params);
		}

		return text;
	}
	
	public static void tmp() {
		Locale locale = Locale.FRENCH;
		String traduction = getDisplayString("MessagesApplicatifs", "login.invalid", locale, new Date(), "Toto", 1L);

		FacesMessage message = new FacesMessage(traduction);
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, message);
	}
}
