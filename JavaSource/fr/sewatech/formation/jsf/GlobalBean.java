package fr.sewatech.formation.jsf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.librairie.dao.CategorieDao;
import org.librairie.dao.ProduitDao;
import org.librairie.model.Categorie;

@ManagedBean(eager=true) @ApplicationScoped
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
			allCategoryItems.add(new SelectItem(categorie.getId(), categorie.getDescription()));
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

	
}
