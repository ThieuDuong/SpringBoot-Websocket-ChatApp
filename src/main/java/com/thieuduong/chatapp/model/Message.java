package com.thieuduong.chatapp.model;

public class Message {
	private String message;
	private String formLogin;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFormLogin() {
		return formLogin;
	}
	public void setFormLogin(String formLogin) {
		this.formLogin = formLogin;
	}
	@Override
	public String toString() {
		return "Message [message=" + message + ", formLogin=" + formLogin + "]";
	}
}
