package fr.sewatech.formation.jsf;

import static com.google.common.collect.Lists.newArrayList;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.librairie.dao.CriteresProduit;
import org.librairie.dao.ProduitDao;
import org.librairie.model.Produit;

@ManagedBean @ViewScoped
public class CatalogueBean implements Serializable {

	private List<Produit> produits;
	private CriteresProduit criteres = new CriteresProduit();
	
	@ManagedProperty("#{globalBean.produitDao}")
	private ProduitDao produitDao;

	@PostConstruct
	public void load() {
		criteres.setIdLangues(newArrayList("F", "E"));
		loadProduits();
	}
	private void loadProduits() {
		System.out.println("load with criteres : " + criteres);
		produits = produitDao.findByCriteres(criteres);
	}
	public void reload() {
		loadProduits();
	}

	public List<Produit> getProduits() {
		return produits;
	}
	
	public CriteresProduit getCriteres() {
		return criteres;
	}
	
	public void setProduitDao(ProduitDao produitDao) {
		this.produitDao = produitDao;
	}
	
	
}
