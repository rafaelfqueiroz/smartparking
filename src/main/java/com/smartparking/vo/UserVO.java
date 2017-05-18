package com.smartparking.vo;

public class UserVO implements VO{

	private String login;
	private String senha;
	private String token;
	
	public UserVO() {}
	
	public UserVO(String login, String senha, String token) {
		this.login = login;
		this.senha = senha;
		this.token = token;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
