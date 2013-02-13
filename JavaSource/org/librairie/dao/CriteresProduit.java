package org.librairie.dao;

import java.io.Serializable;
import java.util.List;

import com.google.common.base.Objects;

public class CriteresProduit implements Serializable {
	private String titre;
	private String idCategorie;
	private List<String> idLangues;
	private String typePrix;
	
	public CriteresProduit() {
		
	}

	public CriteresProduit(String titre, String idCategorie, List<String> idLangues, String typePrix) {
		this.titre = titre;
		this.idCategorie = idCategorie;
		this.idLangues = idLangues;
		this.typePrix = typePrix;
	}

	public String getIdCategorie() {
		return idCategorie;
	}

	public List<String> getIdLangues() {
		return idLangues;
	}

	public String getTitre() {
		return titre;
	}

	public String getTypePrix() {
		return typePrix;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public void setIdLangues(List<String> idLangues) {
		this.idLangues = idLangues;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
					.add("titre", titre)
					.add("idCategorie", idCategorie)
					.toString();
	}
}
