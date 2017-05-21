package com.smartparking.vo;

import java.util.HashMap;
import java.util.Map;

import com.smartparking.domain.User;

public class UserVO implements VO{

	private static final long serialVersionUID = 1190442170709652634L;

	private String login;
	private String password;
	private String token;
	
	public UserVO() {}
	
	public UserVO(String login, String password, String token) {
		this.login = login;
		this.password = password;
		this.token = token;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public static UserVO of(User user) {
		return new UserVO(user.getLogin(), user.getPassword(), user.getToken());
	}

	@Override
	public Map<String, Object> parseToMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("login", login);
		map.put("token", token);
		return map;
	}
	
	
}
