package fr.sewatech.formation.jsf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
public class LoginBean {
	private String login;
	private String password;

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
		return "menu";
	}
	
	public void onLoginChange(ValueChangeEvent event) {
		System.out.println("Login has changed : " + event.getNewValue());
	}
}
