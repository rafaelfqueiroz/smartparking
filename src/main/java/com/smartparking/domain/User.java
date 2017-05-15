package com.smartparking.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.smartparking.interfaces.Feed;

@Entity
@Table(name="usuario")
public class User implements Feed {

	private static final long serialVersionUID = -4270237293037639138L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String login;
	private String senha;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CarParking> cars;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
