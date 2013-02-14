package fr.sewatech.formation.jsf;

import java.util.Date;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean @SessionScoped
public class LoginBean {
	private String login;
	private String password;
	private boolean valid;

	@PostConstruct
	public void init() {
		System.out.println("=== init");
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getMaintenant() {
		return new Date();
	}
	
	public String connecter() {
		System.out.println("Connecter...");
		valid = true;
		return "menu";
	}
	
	public String annuler() {
		System.out.println("Annuler...");
		return null;		
	}
	
	public void onLoginChange(ValueChangeEvent event) {
		System.out.println("Login has changed : " + event.getNewValue());
	}

	public boolean isValid() {
		return valid;
	}
	
	
}
