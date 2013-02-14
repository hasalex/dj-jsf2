package fr.sewatech.formation.jsf;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean @ViewScoped
public class DateBean implements Serializable{
	private Date date;
	
	public DateBean() {
		date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
